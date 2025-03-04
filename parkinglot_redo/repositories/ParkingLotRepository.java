package parkinglot_redo.repositories;

import parkinglot_redo.models.Gate;
import parkinglot_redo.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ParkingLotRepository {
    private Map<Long,ParkingLot> map = new HashMap<>();
    private long previousId=0;

    public Optional<ParkingLot> findByGate(Gate gate){
        return map.values()
                .stream()
                .filter(parkingLot -> parkingLot.getGates().contains(gate))
                .findFirst();
    }
    public ParkingLot save(ParkingLot parkingLot){
        previousId+=1;
        parkingLot.setId(previousId);
        map.put(previousId,parkingLot);
        return parkingLot;
    }
}
