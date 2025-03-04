package parkinglot_redo.repositories;

import parkinglot_redo.models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {
    private Map<Long, Gate> map = new HashMap<>();
    private long prevId =0;
    public Optional<Gate> findByGateId(long id){
        return Optional.ofNullable(map.get(id));
    }

    public Gate save(Gate gate){
        prevId +=1;
        gate.setId(prevId);
        gate.setGateNumber(prevId);
        map.put(prevId,gate);
        return gate;
    }
}
