package parkinglot_redo;

import parkinglot_redo.contorllers.BillController;
import parkinglot_redo.contorllers.TicketController;
import parkinglot_redo.dtos.IssueBillRequestDTO;
import parkinglot_redo.dtos.IssueBillResponseDTO;
import parkinglot_redo.dtos.IssueTicketRequestDTO;
import parkinglot_redo.dtos.IssueTicketResponseDTO;
import parkinglot_redo.models.PaymentMode;
import parkinglot_redo.models.Ticket;
import parkinglot_redo.models.VehicleType;
import parkinglot_redo.repositories.*;
import parkinglot_redo.services.BillGenService;
import parkinglot_redo.services.TicketService;

public class ParkingLotRedoApplication {
    public static void main(String[] args) {
        GateRepository gateRepository = new GateRepository();
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        VehicleRepository vehicleRepository = new VehicleRepository();
        TicketRepository ticketRepository = new TicketRepository();

        TicketService ticketService = new TicketService(gateRepository,parkingLotRepository,vehicleRepository,ticketRepository);
        TicketController ticketController = new TicketController(ticketService);

        IssueTicketResponseDTO responseDTO = ticketController.issueTicket(getIssueTicketRequestDTO("Abhishek","RC007EX8055"));
        System.out.println(responseDTO);

//        IssueTicketResponseDTO responseDTO2 = ticketController.issueTicket(getIssueTicketRequestDTO("Ak007","FC47EX8055"));
//        System.out.println(responseDTO2);

        BillRepository billRepository = new BillRepository();
        BillGenService billGenService = new BillGenService(vehicleRepository,billRepository);
        BillController billController = new BillController(billGenService);
        System.out.println("Bill for ::"+responseDTO.getTicket());
        IssueBillResponseDTO billResponseDTO = billController.issueBill(getIssueBillRequestDTO(responseDTO.getTicket(), PaymentMode.ONLINE));
        System.out.println(billResponseDTO);
    }

    private static IssueTicketRequestDTO getIssueTicketRequestDTO(String name,String vehicleNumber){
        IssueTicketRequestDTO requestDTO = new IssueTicketRequestDTO();
        requestDTO.setGateId(1L);
        requestDTO.setVehicleNumber(vehicleNumber);
        requestDTO.setVehicleType(VehicleType.TWO_WHEELER);
        requestDTO.setOwnerName(name);
        return requestDTO;
    }

    private static IssueBillRequestDTO getIssueBillRequestDTO(Ticket ticket, PaymentMode paymentMode){
        IssueBillRequestDTO requestDTO = new IssueBillRequestDTO();
        requestDTO.setTicket(ticket);
        requestDTO.setPaymentMode(paymentMode);
        return requestDTO;
    }


}
