package parkinglot.services;

import parkinglot.exceptions.GateNotFoundException;
import parkinglot.exceptions.ParkingLotNotFoundException;
import parkinglot.factories.SpotAssignmentFactory;
import parkinglot.models.*;
import parkinglot.repositories.GateRepository;
import parkinglot.repositories.ParkingLotRepository;
import parkinglot.repositories.TicketRepository;
import parkinglot.repositories.VehicleRepository;
import parkinglot.strategies.spotassignmnetstrategy.SpotAssignmentStrategy;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    private final GateRepository gateRepository;
    private final VehicleRepository vehicleRepository;
    private final TicketRepository ticketRepository;
    private final ParkingLotRepository parkingLotRepository;

    public TicketService(GateRepository gateRepository,VehicleRepository vehicleRepository,TicketRepository ticketRepository,ParkingLotRepository parkingLotRepository){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;

        // Initialize SpotAssignmentFactory with ParkingLotRepository
        SpotAssignmentFactory.initialize(parkingLotRepository);
        System.out.println("Initialized TicketService with ParkingLotRepository: " + this.parkingLotRepository);
    }

    public Gate generateDefaultGate(Gate gate){
        //        Generate dummy gate and store int repository
        return gateRepository.save(gate);

    }

    public ParkingLot generateDefaultParkingLot(ParkingLot parkingLot){
        //        Generate dummy gate and store int repository
        return parkingLotRepository.save(parkingLot);

    }
    public Ticket issueTicket(VehicleType vehicleType, String vehicleNumber, String vehicleOwnerName, long gateId) throws GateNotFoundException, ParkingLotNotFoundException {
//        1. validate the parameters
//                check if the vehicle has an  existing entry in the system
//        2.generate ticket -> create an object of Ticket
//        3.Assigning the parking lot
//        4.Return the ticket



//        This will get the valid gate if gateid is valid fm db
//        Gate gate = gateRepository.findById(gateId);
//        What if gate is null then ticket below will throw error so use Optional

//        Optional<Gate> gateOptional = gateRepository.findById(gateId);
//        if(gateOptional.isEmpty()){
//            throw new GateNotFoundException();
//        }
//
//        Gate generatedAt = gateOptional.get();

//        Above logic -> shorthand
        Gate generatedAt = gateRepository.findById(gateId)
                .orElseThrow(GateNotFoundException::new);


//        --> If Vehicle already in the DB retrive it else store and return the vehicle
//        Optional<Vehicle> vehicleOptional = vehicleRepository.findByVehicleByNumber(vehicleNumber);
//        Vehicle savedVehicle;
//
//        if(vehicleOptional.isEmpty()){
//            Vehicle vehicle = new Vehicle();
//            vehicle.setVehicleNumber(vehicleNumber);
//            vehicle.setOwnerName(vehicleOwnerName);
//            vehicle.setType(vehicleType);
//            savedVehicle = vehicleRepository.save(vehicle);
//        }else{
//            savedVehicle = vehicleOptional.get();
//        }


        //        Above logic -> shorthand
        Vehicle savedVehicle = vehicleRepository.findByVehicleByNumber(vehicleNumber)
                .orElseGet(()->createNewVehicle(vehicleType,vehicleNumber,vehicleOwnerName));

        //        How to assign the ParkingSpot ?
//        A gate is bound to spefic parking spot so fetch the parking spot from gate
//        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.findByGate(generatedAt);
//        if(parkingLotOptional.isEmpty()){
//            throw new ParkingLotNotFoundException();
//        }
//        ParkingLot parkingLot = parkingLotOptional.get();

        //        Above logic -> shorthand
        ParkingLot parkingLot = parkingLotRepository.findByGate(generatedAt)
                .orElseThrow(ParkingLotNotFoundException::new);
        System.out.println("Call Passed pl"+ parkingLot);
        SpotAssignmentStrategyType spotAssignmentStrategyType = parkingLot.getSpotAssignmentStrategyType();
        System.out.println(spotAssignmentStrategyType);
        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentFactory.getSpotAssignmentStrategyForType(spotAssignmentStrategyType);
//        we need gate details to find the nearest spot wrt to vehicle type
        System.out.println(spotAssignmentStrategy==null);
        ParkingSpot spot = spotAssignmentStrategy.getSpot(generatedAt,vehicleType);
        System.out.println("Spot ass strt:" + spot);

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        ticket.setGeneratedAt(generatedAt);
        ticket.setGeneratedBy(generatedAt.getCurrentOperator());
        ticket.setVehicle(savedVehicle);

//        How to assign the ParkingSpot ?
//        A gate is bound to spefic parking spot so fetch the parking spot from gate
        ticket.setAssignedSpot(spot);
        ticket=  ticketRepository.save(ticket);
        System.out.println("Ticket gen: "+ticket);
        return ticket;
    }
    private Vehicle createNewVehicle(VehicleType vehicleType,String vehicleNumber,String vehicleOwnerName){

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber(vehicleNumber);
        vehicle.setOwnerName(vehicleOwnerName);
        vehicle.setType(vehicleType);
        return vehicleRepository.save(vehicle);
    }
}
