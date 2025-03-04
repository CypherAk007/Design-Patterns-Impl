package parkinglot_redo.models;


import java.util.Date;

public class Ticket extends BaseModel {
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
    public void display(){
        int maxLength = 0;
        String[] lines = {
                "Ticket Invoice",
                String.format("%s",this.getNumber()),
                String.format("Entry Time : %s",this.getEntryTime()),
                String.format("Assigned Spot : Floor#%s Spot#%s, ",this.getAssignedSpot().getFloor().getNumber(),this.getAssignedSpot().getSpotNumber()),
                String.format("Issuer : %s - %s",this.generatedBy.getName(),this.generatedBy.getId()),
                "Have a Nice Day!!"
        };
        // Find the longest line
        for (String line : lines) {
            if (line.length() > maxLength) {
                maxLength = line.length();
            }
        }
        String border = "+"+"-".repeat(maxLength+4)+"+";
        System.out.println(border);
        for(String line: lines){
            System.out.println("|  "+line+" ".repeat(maxLength-line.length())+"  |");
        }
        System.out.println(border);
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
