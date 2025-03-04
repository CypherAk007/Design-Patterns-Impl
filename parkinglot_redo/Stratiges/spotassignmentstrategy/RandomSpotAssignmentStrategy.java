package parkinglot_redo.Stratiges.spotassignmentstrategy;

import parkinglot_redo.exceptions.ParkingLotNotFoundException;
import parkinglot_redo.models.*;
import parkinglot_redo.repositories.ParkingLotRepository;

import java.util.Optional;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{
    private ParkingLotRepository parkingLotRepository;
    public RandomSpotAssignmentStrategy(ParkingLotRepository parkingLotRepository){
        this.parkingLotRepository = parkingLotRepository;
    }
    @Override
    public ParkingSpot getSpot(Gate gate, VehicleType vehicleType) throws ParkingLotNotFoundException {
        Optional<ParkingLot> parkingLotOptional = parkingLotRepository.findByGate(gate);
        if(parkingLotOptional.isEmpty()){
            throw new ParkingLotNotFoundException();
        }
        ParkingLot parkingLot = parkingLotOptional.get();
        for(ParkingFloor parkingFloor:parkingLot.getFloors()){
            for (ParkingSpot parkingSpot:parkingFloor.getParkingSpots()){
                if(parkingSpot.getStatus().equals(ParkingSpotStatus.EMPTY) && parkingSpot.getVehicleType().contains(vehicleType)){
                    return parkingSpot;
                }
            }
        }
        return null;
    }
}
