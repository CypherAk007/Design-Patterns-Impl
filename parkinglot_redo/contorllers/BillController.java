package parkinglot_redo.contorllers;

import parkinglot_redo.dtos.IssueBillRequestDTO;
import parkinglot_redo.dtos.IssueBillResponseDTO;
import parkinglot_redo.dtos.IssueTicketResponseDTO;
import parkinglot_redo.dtos.ResponseStatus;
import parkinglot_redo.models.Bill;
import parkinglot_redo.services.BillGenService;

public class BillController {
    private BillGenService billGenService;
    public BillController(BillGenService billGenService){
        this.billGenService = billGenService;
    }

    public IssueBillResponseDTO issueBill(IssueBillRequestDTO requestDTO){
        IssueBillResponseDTO responseDTO = new IssueBillResponseDTO();
        try{
//            System.out.println("Inside bill controller issueBill");
            Bill bill = billGenService.generateBill(requestDTO.getTicket(), requestDTO.getPaymentMode());
            responseDTO.setBill(bill);
            responseDTO.setMessage("Bill Issued Successfully");
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }
}

//bill controller -> bill service -> ln("Bill Is Generated : "+display()); ->display bill ->
