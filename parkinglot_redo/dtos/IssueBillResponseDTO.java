package parkinglot_redo.dtos;

import parkinglot_redo.models.Bill;

public class IssueBillResponseDTO {
    private Bill bill;
    private String message;
    private ResponseStatus responseStatus;

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    @Override
    public String toString() {
        return "IssueBillResponseDTO{" +
                "bill=" + bill +
                ", message='" + message + '\'' +
                ", responseStatus=" + responseStatus +
                '}';
    }
}
