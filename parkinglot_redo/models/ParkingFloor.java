package parkinglot_redo.models;

import java.util.List;

public class ParkingFloor extends BaseModel {

    private List<ParkingSpot> parkingSpots;
    private ParkingFloorStatus status;
    private int number;

    public ParkingFloor(List<ParkingSpot> parkingSpots, ParkingFloorStatus status, int number) {
        this.parkingSpots = parkingSpots;
        this.status = status;
        this.number = number;
    }
    public ParkingFloor(){}

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public ParkingFloorStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingFloorStatus status) {
        this.status = status;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "ParkingFloor{" +
//                "parkingSpots=" + parkingSpots +
                ", status=" + status +
                ", number=" + number +
                '}';
    }
}
