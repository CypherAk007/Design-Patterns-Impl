package parkinglot_redo.services;


import parkinglot_redo.Stratiges.spotassignmentstrategy.SpotAssignmentStrategy;
import parkinglot_redo.exceptions.GateNotFoundException;
import parkinglot_redo.exceptions.ParkingLotNotFoundException;
import parkinglot_redo.factory.SpotAssignmentFactory;
import parkinglot_redo.models.*;
import parkinglot_redo.repositories.GateRepository;
import parkinglot_redo.repositories.ParkingLotRepository;
import parkinglot_redo.repositories.TicketRepository;
import parkinglot_redo.repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {
    private GateRepository gateRepository;
    private ParkingLotRepository parkingLotRepository;
    private VehicleRepository vehicleRepository;
    private TicketRepository ticketRepository;

    public TicketService(GateRepository gateRepository, ParkingLotRepository parkingLotRepository, VehicleRepository vehicleRepository, TicketRepository ticketRepository) {
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;

        // Initialize SpotAssignmentFactory with ParkingLotRepository
        SpotAssignmentFactory.initialize(parkingLotRepository);
//        System.out.println("Initialized TicketService with ParkingLotRepository: " + this.parkingLotRepository);
    }

    public Ticket issueTicket(String vehicleNumber, VehicleType vehicleType,String ownerName,long gateId) throws GateNotFoundException, ParkingLotNotFoundException {
        //        1. validate the parameters
        //                check if the vehicle has an  existing entry in the system
        //        2.generate ticket -> create an object of Ticket
        //        3.Assigning the parking lot -> find the spot..
        //        4.Return the ticket

        Optional<Gate> gateOptional =gateRepository.findByGateId(gateId);
        if (gateOptional.isEmpty()){
            throw new GateNotFoundException();
        }
        Gate generatedAt = gateOptional.get();

        Optional<Vehicle> vehicleOptional = vehicleRepository.findByVehicleNumber(vehicleNumber);
        Vehicle vehicle;
        if(vehicleOptional.isEmpty()){
            vehicle=createNewVehicleEntry(vehicleNumber,vehicleType,ownerName);
        }else{
            vehicle = vehicleOptional.get();
        }

        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.findByGate(generatedAt);
        if(parkingLotOptional.isEmpty()){
            throw new ParkingLotNotFoundException();
        }

        ParkingLot parkingLot = parkingLotOptional.get();
        SpotAssignmentStrategyType spotAssignmentStrategyType = parkingLot.getSpotAssignmentStrategyType();
        SpotAssignmentStrategy spotAssignmentStrategy = SpotAssignmentFactory.getSpotAssignmentStrategyForType(spotAssignmentStrategyType);

        ParkingSpot parkingSpot = spotAssignmentStrategy.getSpot(generatedAt,vehicleType);
        System.out.println("Parking Spot Found: "+parkingSpot);
        parkingSpot.setStatus(ParkingSpotStatus.OCCUPIED);


        Ticket ticket = new Ticket();
        ticket.setAssignedSpot(parkingSpot);
        ticket.setEntryTime(new Date());
        ticket.setVehicle(vehicle);
        ticket.setGeneratedBy(generatedAt.getCurrentOperator());
        ticket.setAssignedSpot(parkingSpot);
        ticket = ticketRepository.save(ticket);
        System.out.println("Generated Ticket : ");
        ticket.display();
        return ticket;
    }

    private Vehicle createNewVehicleEntry(String vehicleNumber, VehicleType vehicleType, String ownerName) {
        Vehicle vehicle  = new Vehicle();
        vehicle.setVehicleNumber(vehicleNumber);
        vehicle.setType(vehicleType);
        vehicle.setOwnerName(ownerName);
        vehicleRepository.save(vehicle);
        return vehicle;
    }

    public Gate generateDefaultGate(Gate gate){
        //        Generate dummy gate and store int repository
        return gateRepository.save(gate);

    }

    public ParkingLot generateDefaultParkingLot(ParkingLot parkingLot){
        //        Generate dummy gate and store int repository
        return parkingLotRepository.save(parkingLot);

    }
}
