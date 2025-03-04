package parkinglot_redo.models;

import java.util.Date;
import java.util.List;

public class Bill extends BaseModel {
    private Date exitTime;
    private long billNuber;
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

    public long getBillNuber() {
        return billNuber;
    }

    public void setBillNuber(long billNuber) {
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

    public void display(){
        int maxLength = 0;
        String[] lines = {
                "Bill Invoice",
                String.format("Bill#%s",billNuber),
                String.format("Ticket#%s",ticket.getNumber()),
                String.format("Exit Time : %s",this.getExitTime()),
                String.format("Total Amount Paid: %s",this.getAmount()),
                String.format("PaymentRef No. : %s",this.getPayments().getFirst().getReferenceNumber()),
                String.format("Issuer : %s - %s",this.getCollectedBy().getName(),this.getCollectedBy().getId()),
                "Thank You!! Visit Again!!"
        };
        // Find the longest line
        for (String line : lines) {
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }
        String border = "+"+"-".repeat(maxLength+4)+"+";
        System.out.println(border);
        for(String line: lines){
            System.out.println("|  "+line+" ".repeat(maxLength-line.length())+"  |");
        }
        System.out.println(border);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "exitTime=" + exitTime +
                ", billNuber=" + billNuber +
                ", ticket=" + ticket +
                ", amount=" + amount +
                ", collectedAt=" + collectedAt +
                ", collectedBy=" + collectedBy +
                ", status=" + status +
                ", payments=" + payments +
                '}';
    }
}
