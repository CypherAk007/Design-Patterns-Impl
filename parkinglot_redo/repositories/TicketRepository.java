package parkinglot_redo.repositories;

import parkinglot_redo.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {
    private Map<Long,Ticket> map = new HashMap<>();
    private long previousId;
    public Ticket save(Ticket ticket){
        previousId +=1;
        ticket.setId(previousId);
        ticket.setNumber("Ticket# "+previousId);
        map.put(previousId,ticket);
        return ticket;
    }
}
