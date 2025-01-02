package parkinglot.dtos;

import parkinglot.models.Gate;
import parkinglot.models.ParkingSpot;
import parkinglot.models.Vehicle;
import parkinglot.models.VehicleType;

public class IssueTicketRequestDTO {
    private VehicleType vehicleType;
    private String vehicleNumber;
    private String vehicleOwnerName;
    private long gateId;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleOwnerName() {
        return vehicleOwnerName;
    }

    public void setVehicleOwnerName(String vehicleOwnerName) {
        this.vehicleOwnerName = vehicleOwnerName;
    }

    public long getGateId() {
        return gateId;
    }

    public void setGateId(long gateId) {
        this.gateId = gateId;
    }
}
