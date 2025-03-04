package parkinglot_redo.exceptions;

public class VehicleNotFoundException extends RuntimeException {
    public VehicleNotFoundException() {
        super("Invalid Vehicle Details!!");
    }
}
