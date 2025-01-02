package parkinglot.services;

import parkinglot.exceptions.GateNotFoundException;
import parkinglot.models.Gate;
import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;
import parkinglot.models.VehicleType;
import parkinglot.repositories.GateRepository;
import parkinglot.repositories.TicketRepository;
import parkinglot.repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;

public class TicketService {

    private final GateRepository gateRepository;
    private final VehicleRepository vehicleRepository;
    private final TicketRepository ticketRepository;
    public TicketService(GateRepository gateRepository,VehicleRepository vehicleRepository,TicketRepository ticketRepository){
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
        this.ticketRepository = ticketRepository;
    }

    public Ticket issueTicket(VehicleType vehicleType, String vehicleNumber, String vehicleOwnerName, long gateId) throws GateNotFoundException {
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

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());
        ticket.setGeneratedAt(generatedAt);
        ticket.setGeneratedBy(generatedAt.getCurrentOperator());
        ticket.setVehicle(savedVehicle);



        return  ticketRepository.save(ticket);

    }
    private Vehicle createNewVehicle(VehicleType vehicleType,String vehicleNumber,String vehicleOwnerName){

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber(vehicleNumber);
        vehicle.setOwnerName(vehicleOwnerName);
        vehicle.setType(vehicleType);
        return vehicleRepository.save(vehicle);
    }
}
