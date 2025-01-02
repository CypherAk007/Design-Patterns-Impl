package parkinglot.repositories;

import parkinglot.models.Gate;
import parkinglot.models.ParkingLot;


import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class ParkingLotRepository {
    Map<Long, ParkingLot> parkingLotMap = new TreeMap<>();

    private long previousId = 0L;

    public Optional<ParkingLot> findByGate(Gate gate){
        return parkingLotMap.values()
                .stream()
                .filter(parkingLot -> parkingLot.getGates().contains(gate))
                .findFirst();
    }

    public ParkingLot save(ParkingLot parkingLot) {
        previousId+=1;
        parkingLot.setId(previousId);
        parkingLotMap.put(previousId,parkingLot);
        System.out.println("Saved ParkingLot: " + parkingLot);
        return parkingLot;

    }
}
