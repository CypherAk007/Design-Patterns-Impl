package parkinglot.dtos;

import parkinglot.models.Ticket;

public class IssueTicketResponseDTO {
    private Ticket ticket;
    private String message;
    private ResponseStatus status;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "IssueTicketResponseDTO{" +
                "ticket=" + ticket +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
