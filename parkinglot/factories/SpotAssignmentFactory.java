package parkinglot.factories;

import parkinglot.models.SpotAssignmentStrategyType;
import parkinglot.repositories.ParkingLotRepository;
import parkinglot.strategies.spotassignmnetstrategy.NearestFirstSpotAssignmentStrategy;
import parkinglot.strategies.spotassignmnetstrategy.RandomSpotAssignmentStrategy;
import parkinglot.strategies.spotassignmnetstrategy.SpotAssignmentStrategy;

public class SpotAssignmentFactory {
    private static ParkingLotRepository parkingLotRepository;

    // Initialize the factory with the required dependencies
    public static void initialize(ParkingLotRepository repo) {
        parkingLotRepository = repo;
    }

    public static SpotAssignmentStrategy getSpotAssignmentStrategyForType(SpotAssignmentStrategyType type){
     return switch (type){
         case NEAREST_FIRST -> new NearestFirstSpotAssignmentStrategy(parkingLotRepository);
         case RANDOM -> new RandomSpotAssignmentStrategy(parkingLotRepository);
         default -> new RandomSpotAssignmentStrategy(parkingLotRepository);
     };
    }
}
