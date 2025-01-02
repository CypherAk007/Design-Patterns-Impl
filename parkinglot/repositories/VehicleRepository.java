package parkinglot.repositories;

import parkinglot.models.Vehicle;

import java.util.Optional;
import java.util.Map;
import java.util.TreeMap;

public class VehicleRepository {

    Map<Long,Vehicle> vehicleMap = new TreeMap<>();
    private long previousId = 0;
    public Optional<Vehicle> findByVehicleByNumber(String vehicleNumber) {
        return vehicleMap.values()
                .stream()
                .filter(vehicle -> vehicle.getVehicleNumber().equals(vehicleNumber))
                .findFirst();
    }

    public Vehicle save(Vehicle vehicle) {
        previousId = previousId+1;
        vehicle.setId(previousId);
        vehicleMap.put(previousId,vehicle);
        return vehicle;

    }
}
