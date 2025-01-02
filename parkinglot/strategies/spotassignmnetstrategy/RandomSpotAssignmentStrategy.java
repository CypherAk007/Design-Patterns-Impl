package parkinglot.strategies.spotassignmnetstrategy;

import parkinglot.exceptions.GateNotFoundException;
import parkinglot.models.*;
import parkinglot.repositories.ParkingLotRepository;

public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy{

    private ParkingLotRepository parkingLotRepository;
    public RandomSpotAssignmentStrategy(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }
    @Override
    public ParkingSpot getSpot(Gate gate, VehicleType vehicleType) throws GateNotFoundException {
//        we need to find if spot is available or not
//        We make a call to DB for Parking lot info
//                next we use parkinglot to get ParkingFloor
//                next with parking floor we get -> ParkingSpot
        System.out.println(gate+" "+vehicleType);
        ParkingLot parkingLot = parkingLotRepository.findByGate(gate)
                .orElseThrow(GateNotFoundException::new);

        for(ParkingFloor parkingFloor: parkingLot.getFloors()){
            for (ParkingSpot spot:parkingFloor.getParkingSpots()){
                System.out.println("stratgy random"+ spot);
                if(spot.getStatus().equals(ParkingSpotStatus.EMPTY)&& spot.getVehicleType().contains(vehicleType)){
                    return spot;
                }
            }
        }
        return null;

    }
}
