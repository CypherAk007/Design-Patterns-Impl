package parkinglot_redo.dtos;

import parkinglot_redo.models.PaymentMode;
import parkinglot_redo.models.Ticket;
import parkinglot_redo.models.VehicleType;

public class IssueBillRequestDTO {
    private Ticket ticket;
    private long gateId;
    private PaymentMode paymentMode;

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public long getGateId() {
        return gateId;
    }

    public void setGateId(long gateId) {
        this.gateId = gateId;
    }
}
