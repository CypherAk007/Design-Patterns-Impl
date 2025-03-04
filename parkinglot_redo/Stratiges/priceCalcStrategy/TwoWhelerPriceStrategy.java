package parkinglot_redo.Stratiges.priceCalcStrategy;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TwoWhelerPriceStrategy implements PriceCalculationStrategy {
    @Override
    public int calculatePrice(Date entryTime) {
        Date currentTime = new Date();
        long parkingtime = currentTime.getTime()-entryTime.getTime();
        System.out.println("Total Time Parked : "+ formatParkingTime(parkingtime));
        double parkingHours = Math.ceil(parkingtime/(1000.0*60*60));
        int parkingPrice = 0;
        if(parkingHours>=2){
            parkingPrice+= 2*20;
        } else{
            parkingPrice+= 2*20;
            return parkingPrice;
        }
        if (parkingHours>=4) {
            parkingPrice+= 2*25;
        }else {
            parkingPrice+= 2*25;
            return parkingPrice;
        }

        if (parkingHours<=6) {
            parkingPrice+= 2*30;
        }
        if(parkingHours>6){
            parkingPrice+= (parkingHours-6)*40;
        }
        return parkingPrice;
    }

    public  String formatParkingTime(long millis) {
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis) % 60;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis) % 60;
        long milliseconds = millis % 1000;

        return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds,milliseconds);
    }
}
