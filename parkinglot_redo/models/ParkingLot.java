package parkinglot_redo.models;

import java.util.List;

//Create base model class for audit fields and extend it
//for id,createdBy/At,updatedBy/At
public class ParkingLot extends BaseModel {
    private List<ParkingFloor> floors;
    private List<Gate> gates;
    private List<VehicleType> allowedVehicleTypes;
    private ParkingLotStatus status;

//    Create Enum for strategies for Factory to return specific strategy as per input
    private SpotAssignmentStrategyType spotAssignmentStrategyType;
    private FeeCalculationStrategyType feeCalculationStrategyType;

    public ParkingLot() {
    }

    public ParkingLot(List<ParkingFloor> floors, List<Gate> gates, List<VehicleType> allowedVehicleTypes, ParkingLotStatus status, SpotAssignmentStrategyType spotAssignmentStrategyType) {
        this.floors = floors;
        this.gates = gates;
        this.allowedVehicleTypes = allowedVehicleTypes;
        this.status = status;
        this.spotAssignmentStrategyType = spotAssignmentStrategyType;
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public void setFloors(List<ParkingFloor> floors) {
        this.floors = floors;
    }

    public List<Gate> getGates() {
        return gates;
    }

    public void setGates(List<Gate> gates) {
        this.gates = gates;
    }

    public List<VehicleType> getAllowedVehicleTypes() {
        return allowedVehicleTypes;
    }

    public void setAllowedVehicleTypes(List<VehicleType> allowedVehicleTypes) {
        this.allowedVehicleTypes = allowedVehicleTypes;
    }

    public ParkingLotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingLotStatus status) {
        this.status = status;
    }

    public SpotAssignmentStrategyType getSpotAssignmentStrategyType() {
        return spotAssignmentStrategyType;
    }

    public void setSpotAssignmentStrategyType(SpotAssignmentStrategyType spotAssignmentStrategyType) {
        this.spotAssignmentStrategyType = spotAssignmentStrategyType;
    }

    public FeeCalculationStrategyType getFeeCalculationStrategyType() {
        return feeCalculationStrategyType;
    }

    public void setFeeCalculationStrategyType(FeeCalculationStrategyType feeCalculationStrategyType) {
        this.feeCalculationStrategyType = feeCalculationStrategyType;
    }

    @Override
    public String toString() {
        return "ParkingLot{" +
                "floors=" + floors +
                ", gates=" + gates +
                ", allowedVehicleTypes=" + allowedVehicleTypes +
                ", status=" + status +
                ", spotAssignmentStrategyType=" + spotAssignmentStrategyType +
                ", feeCalculationStrategyType=" + feeCalculationStrategyType +
                '}';
    }
}
