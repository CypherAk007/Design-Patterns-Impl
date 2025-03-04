package parkinglot_redo.Stratiges.spotassignmentstrategy;

import parkinglot_redo.exceptions.ParkingLotNotFoundException;
import parkinglot_redo.models.Gate;
import parkinglot_redo.models.ParkingSpot;
import parkinglot_redo.models.VehicleType;

public interface SpotAssignmentStrategy {
    ParkingSpot getSpot(Gate gate, VehicleType vehicleType) throws ParkingLotNotFoundException;
}
