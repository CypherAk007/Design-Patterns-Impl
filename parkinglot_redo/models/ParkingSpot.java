package parkinglot_redo.models;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpot extends BaseModel {
    private List<VehicleType> vehicleType;
    private ParkingSpotStatus status;
    private ParkingFloor floor;
    private int spotNumber;

    public ParkingSpot(List<VehicleType> vehicleType, ParkingSpotStatus status, ParkingFloor floor, int spotNumber) {
        this.vehicleType = vehicleType;
        this.status = status;
        this.floor = floor;
        this.spotNumber = spotNumber;
    }

    public List<VehicleType> getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(List<VehicleType> vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSpotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSpotStatus status) {
        this.status = status;
    }

    public ParkingFloor getFloor() {
        return floor;
    }

    public void setFloor(ParkingFloor floor) {
        this.floor = floor;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "vehicleType=" + vehicleType +
                ", status=" + status +
                ", floor=" + floor +
                ", spotNumber=" + spotNumber +
                '}';
    }
}
