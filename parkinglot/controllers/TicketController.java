package parkinglot.controllers;

import parkinglot.dtos.IssueTicketRequestDTO;
import parkinglot.dtos.IssueTicketResponseDTO;
import parkinglot.dtos.ResponseStatus;
import parkinglot.models.Gate;
import parkinglot.models.Operator;
import parkinglot.models.Ticket;
import parkinglot.models.Vehicle;
import parkinglot.services.TicketService;

public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
    }


//    public Ticket issueTicket(Vehicle vehicle, Gate gate, Operator operator){
//
//    }

//    REPLACE ABOVE WITH DTO
//    public Ticket issueTicket(IssueTicketRequestDTO requestDTO){
//
//    }

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

        }catch (Exception e){
            responseDTO.setStatus(ResponseStatus.FAILURE );
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }
}
