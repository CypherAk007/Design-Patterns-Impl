package parkinglot_redo.factory;

import parkinglot_redo.Stratiges.priceCalcStrategy.FourWhelerPriceStrategy;
import parkinglot_redo.Stratiges.priceCalcStrategy.PriceCalculationStrategy;
import parkinglot_redo.Stratiges.priceCalcStrategy.TwoWhelerPriceStrategy;
import parkinglot_redo.models.VehicleType;

public class PriceAssignmentFactory {
    public static PriceCalculationStrategy getPriceAssignmentStrategyBasedOnVehicleType(VehicleType type){
        return switch (type){
            case TWO_WHEELER -> new TwoWhelerPriceStrategy();
            case FOUR_WHEELER -> new FourWhelerPriceStrategy();
            case THREE_WHEELER -> new FourWhelerPriceStrategy();
        };
    }
}
