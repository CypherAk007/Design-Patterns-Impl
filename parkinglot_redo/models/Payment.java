package parkinglot_redo.models;

import java.util.Date;

public class Payment extends BaseModel {

    private PaymentMode paymentMode;
    private double amount;
    private PaymentStatus status;
    private String referenceNumber;
    private Date time;

    public Payment(PaymentMode paymentMode, double amount, PaymentStatus status, String referenceNumber, Date time) {
        this.paymentMode = paymentMode;
        this.amount = amount;
        this.status = status;
        this.referenceNumber = referenceNumber;
        this.time = time;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
