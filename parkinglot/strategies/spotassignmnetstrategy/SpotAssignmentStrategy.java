package parkinglot.strategies.spotassignmnetstrategy;

import parkinglot.exceptions.GateNotFoundException;
import parkinglot.models.Gate;
import parkinglot.models.ParkingSpot;
import parkinglot.models.VehicleType;

public interface SpotAssignmentStrategy {

    ParkingSpot getSpot(Gate gate, VehicleType vehicleType) throws GateNotFoundException;
}
