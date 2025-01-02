package parkinglot.models;

import java.util.Date;

public class Payment extends BaseModel {

    private PaymentMode paymentMode;
    private double amount;
    private PaymentStatus status;
    private String referenceNumber;
    private Date time;


}
