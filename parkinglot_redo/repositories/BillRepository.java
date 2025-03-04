package parkinglot_redo.repositories;

import parkinglot_redo.models.Bill;

import java.util.HashMap;
import java.util.Map;

public class BillRepository {

    private Map<Long, Bill> map = new HashMap<>();
    private long previousId=0;
    public Bill save(Bill bill){
        previousId+=1;
        bill.setId(previousId);
        bill.setBillNuber(previousId);
        map.put(previousId,bill);
        return bill;
    }
}
