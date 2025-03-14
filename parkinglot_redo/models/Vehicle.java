package parkinglot_redo.models;

public class Vehicle extends BaseModel {
    private String ownerName;
    private VehicleType type;
    private String vehicleNumber;

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "ownerName='" + ownerName + '\'' +
                ", type=" + type +
                ", vehicleNumber='" + vehicleNumber + '\'' +
                '}';
    }
}
