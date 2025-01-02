package parkinglot.models;


import java.util.Date;

public class Ticket extends BaseModel{
    private Date entryTime;
    private ParkingSpot assignedSpot;
    private String number;
    private Gate generatedAt;
    private Operator generatedBy;
    private Vehicle vehicle;

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public ParkingSpot getAssignedSpot() {
        return assignedSpot;
    }

    public void setAssignedSpot(ParkingSpot assignedSpot) {
        this.assignedSpot = assignedSpot;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Gate getGeneratedAt() {
        return generatedAt;
    }

    public void setGeneratedAt(Gate generatedAt) {
        this.generatedAt = generatedAt;
    }

    public Operator getGeneratedBy() {
        return generatedBy;
    }

    public void setGeneratedBy(Operator generatedBy) {
        this.generatedBy = generatedBy;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "entryTime=" + entryTime +
                ", assignedSpot=" + assignedSpot +
                ", number='" + number + '\'' +
                ", generatedAt=" + generatedAt +
                ", generatedBy=" + generatedBy +
                ", vehicle=" + vehicle +
                '}';
    }
}
