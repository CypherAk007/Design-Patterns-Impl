package parkinglot.exceptions;

public class ParkingLotNotFoundException extends Throwable {
    public ParkingLotNotFoundException(){
        super("Parking Lot Not Found!!");
    }
}
