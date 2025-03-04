package parkinglot_redo.repositories;

import parkinglot_redo.models.Vehicle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class VehicleRepository {
    private Map<Long,Vehicle> vehicleMap = new HashMap<>();
    private long previousId=0;
    public Optional<Vehicle> findByVehicleNumber(String number){

        return vehicleMap.values()
                        .stream()
                        .filter(vehicle-> vehicle.getVehicleNumber().equals(number))
                        .findFirst();
    }

    public Vehicle save(Vehicle vehicle){
        previousId+=1;
        vehicle.setId(previousId);
        vehicleMap.put(previousId,vehicle);
        return vehicle;
    }
}
