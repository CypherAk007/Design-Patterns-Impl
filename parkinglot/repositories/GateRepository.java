package parkinglot.repositories;

import parkinglot.models.Gate;
import parkinglot.models.ParkingLot;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class GateRepository {

    Map<Long, Gate> gateMap = new TreeMap<>();
    private long previousId = 0L;

//    public Gate findById(long gateId) {
//        return null;
//    }
    public Optional<Gate> findById(long gateId) {
        return Optional.ofNullable(gateMap.get(gateId));
    }

    public Gate save(Gate gate) {
        previousId+=1;
        gate.setId(previousId);
        gate.setGateNumber(previousId);
        gateMap.put(previousId,gate);
        return  gate;
    }
}
