package parkinglot.strategies.spotassignmnetstrategy;

import parkinglot.models.Gate;
import parkinglot.models.ParkingSpot;
import parkinglot.models.VehicleType;
import parkinglot.repositories.ParkingLotRepository;

public class NearestFirstSpotAssignmentStrategy implements SpotAssignmentStrategy{

    private ParkingLotRepository parkingLotRepository;
    public NearestFirstSpotAssignmentStrategy(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }
    @Override
    public ParkingSpot getSpot(Gate gate, VehicleType vehicleType) {
        return null;
    }
}
