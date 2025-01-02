package parkinglot.dtos;

import parkinglot.models.Gate;
import parkinglot.models.ParkingSpot;
import parkinglot.models.Vehicle;

public class IssueTicketRequestDTO {
    private Vehicle vehicle;
    private Gate gate;
    private ParkingSpot parkingSpot;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Gate getGate() {
        return gate;
    }

    public void setGate(Gate gate) {
        this.gate = gate;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
