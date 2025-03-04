package parkinglot_redo.exceptions;

public class ParkingLotNotFoundException extends Exception{
    public ParkingLotNotFoundException(){
        super("Parking Lot Not Found");
    }
}
