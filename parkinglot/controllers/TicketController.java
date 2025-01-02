package parkinglot.controllers;

import parkinglot.dtos.IssueTicketRequestDTO;
import parkinglot.dtos.IssueTicketResponseDTO;
import parkinglot.dtos.ResponseStatus;
import parkinglot.exceptions.ParkingLotNotFoundException;
import parkinglot.models.*;
import parkinglot.services.TicketService;

import java.util.ArrayList;
import java.util.List;

public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService){
        System.out.println("init service class");
        this.ticketService = ticketService;
        System.out.println("Generating dummy data");
        generateDummyData();
    }


//    public Ticket issueTicket(Vehicle vehicle, Gate gate, Operator operator){
//
//    }

//    REPLACE ABOVE WITH DTO
//    public Ticket issueTicket(IssueTicketRequestDTO requestDTO){
//
//    }

    public void generateDummyData(){
        //        Generate dummy gate and store int repository
        Operator operator = new Operator("Ak");
        Gate defaultGate = new Gate(GateStatus.OPEN,operator,GateType.ENTRY);
//        gateRepository.save(defaultGate);
        defaultGate  = ticketService.generateDefaultGate(defaultGate);
        System.out.println(defaultGate);

        ParkingLot defaultPl = new ParkingLot(new ArrayList<>(),
                new ArrayList<>(List.of(defaultGate)),
                new ArrayList<>(List.of(VehicleType.TWO_WHEELER,VehicleType.THREE_WHEELER,VehicleType.FOUR_WHEELER)),
                ParkingLotStatus.OPERATIONAL,
                SpotAssignmentStrategyType.RANDOM
                );
        defaultPl = ticketService.generateDefaultParkingLot(defaultPl);
        System.out.println(defaultPl);


    }

//    WE NEED RESPONSE DTO INCASE TICKET WAS NOT GENERATED - GRACEFULLY SENDING CLIENT THE MESSAGE
    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO requestDTO){

        IssueTicketResponseDTO responseDTO = new IssueTicketResponseDTO();
        try{
            Ticket ticket = ticketService.issueTicket(requestDTO.getVehicleType(),
                    requestDTO.getVehicleNumber(),
                    requestDTO.getVehicleOwnerName(),
                    requestDTO.getGateId());
            responseDTO.setTicket(ticket);
            responseDTO.setMessage("Ticket Generated Successfully!!!");
            responseDTO.setStatus(ResponseStatus.SUCCESS);

        }catch (Exception | ParkingLotNotFoundException e){
            responseDTO.setStatus(ResponseStatus.FAILURE );
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }
}
