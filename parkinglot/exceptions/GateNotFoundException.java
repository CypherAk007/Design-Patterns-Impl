package parkinglot.exceptions;

public class GateNotFoundException extends Exception {
    public GateNotFoundException() {
        super("Gate not Found");
    }
}
