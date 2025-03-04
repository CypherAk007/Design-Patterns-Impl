package parkinglot_redo.factory;

import parkinglot_redo.Stratiges.spotassignmentstrategy.RandomSpotAssignmentStrategy;
import parkinglot_redo.Stratiges.spotassignmentstrategy.SpotAssignmentStrategy;
import parkinglot_redo.models.SpotAssignmentStrategyType;
import parkinglot_redo.repositories.ParkingLotRepository;

public class SpotAssignmentFactory {
    private static ParkingLotRepository parkingLotRepository;
    public static void initialize(ParkingLotRepository repository){
        parkingLotRepository = repository;

    }
    public static SpotAssignmentStrategy getSpotAssignmentStrategyForType(SpotAssignmentStrategyType type){
        return switch (type){
            case NEAREST_FIRST -> null;
            case RANDOM -> new RandomSpotAssignmentStrategy(parkingLotRepository);
        };
    }
}
