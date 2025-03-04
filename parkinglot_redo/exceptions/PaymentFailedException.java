package parkinglot_redo.exceptions;

public class PaymentFailedException extends RuntimeException {
    public PaymentFailedException() {
        super("Payment Failed due to some Technical Issue!!");
    }
}
