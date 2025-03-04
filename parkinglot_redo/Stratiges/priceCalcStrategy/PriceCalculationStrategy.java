package parkinglot_redo.Stratiges.priceCalcStrategy;

import java.util.Date;

public interface PriceCalculationStrategy {
    int calculatePrice(Date entryTime);
}