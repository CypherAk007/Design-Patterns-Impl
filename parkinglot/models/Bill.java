package parkinglot.models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel{
    private Date exitTime;
    private int billNuber;
    private Ticket ticket;
    private double amount;
    private Gate collectedAt;
    private Operator collectedBy;
    private BillStatus status;
    private List<Payment> payments;

    public Bill(Ticket ticket){
        this.exitTime = new Date();
        this.status = BillStatus.UNPAID;
        this.ticket = ticket;

    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public int getBillNuber() {
        return billNuber;
    }

    public void setBillNuber(int billNuber) {
        this.billNuber = billNuber;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Gate getCollectedAt() {
        return collectedAt;
    }

    public void setCollectedAt(Gate collectedAt) {
        this.collectedAt = collectedAt;
    }

    public Operator getCollectedBy() {
        return collectedBy;
    }

    public void setCollectedBy(Operator collectedBy) {
        this.collectedBy = collectedBy;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
