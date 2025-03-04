package parkinglot_redo.contorllers;



import parkinglot_redo.dtos.IssueTicketRequestDTO;
import parkinglot_redo.dtos.IssueTicketResponseDTO;
import parkinglot_redo.dtos.ResponseStatus;
import parkinglot_redo.exceptions.ParkingLotNotFoundException;
import parkinglot_redo.models.*;
import parkinglot_redo.services.TicketService;

import java.util.ArrayList;
import java.util.List;

public class TicketController {
    private TicketService ticketService;
    public TicketController(TicketService ticketService){
        this.ticketService = ticketService;
        System.out.println(" :::  ===  === :::===== :::      :::===== :::====  :::=======  :::=====      :::==== :::====       :::====  :::  === :::====  :::====  :::      :::=======  :::====  :::      :::          \n" +
                " :::  ===  === :::      :::      :::      :::  === ::: === === :::           :::==== :::  ===      :::  === :::  === :::  === :::  === :::      ::: === === :::  === :::      :::          \n" +
                " ===  ===  === ======   ===      ===      ===  === === === === ======          ===   ===  ===      ===  === ===  === =======  ======== ===      === === === ======== ===      ===          \n" +
                "  ===========  ===      ===      ===      ===  === ===     === ===             ===   ===  ===      ===  === ===  === ===  === ===  === ===      ===     === ===  === ===      ===          \n" +
                "   ==== ====   ======== ========  =======  ======  ===     === ========        ===    ======       =======   ======  =======  ===  === ===      ===     === ===  === ======== ========     \n" +
                "                                                                                                                                                                                           \n" +
                "                                              :::====  :::====  :::====  :::  === ::: :::= === :::=====       :::      :::====  :::====                                                    \n" +
                "                                              :::  === :::  === :::  === ::: ===  ::: :::===== :::            :::      :::  === :::====                                                    \n" +
                "                                              =======  ======== =======  ======   === ======== === =====      ===      ===  ===   ===                                                      \n" +
                "                                              ===      ===  === === ===  === ===  === === ==== ===   ===      ===      ===  ===   ===                                                      \n" +
                "                                              ===      ===  === ===  === ===  === === ===  ===  =======       ========  ======    ===                                                      \n" +
                "                                                                                                                                                                                           ");
        generateDummyData();
    }
    public void generateDummyData(){
        //        Generate dummy gate and store int repository
        Operator operator = new Operator("Ak");
        Gate defaultGate = new Gate(GateStatus.OPEN,operator, GateType.ENTRY);
//        gateRepository.save(defaultGate);
        defaultGate  = ticketService.generateDefaultGate(defaultGate);
//        System.out.println(defaultGate);
        ParkingFloor parkingFloor = new ParkingFloor();
        parkingFloor.setParkingSpots(List.of(new ParkingSpot(new ArrayList<>(List.of(VehicleType.TWO_WHEELER)), ParkingSpotStatus.EMPTY,parkingFloor,1),
                new ParkingSpot(new ArrayList<>(List.of(VehicleType.TWO_WHEELER)), ParkingSpotStatus.EMPTY,parkingFloor,2),
                new ParkingSpot(new ArrayList<>(List.of(VehicleType.TWO_WHEELER)), ParkingSpotStatus.EMPTY,parkingFloor,3),
                new ParkingSpot(new ArrayList<>(List.of(VehicleType.TWO_WHEELER)),ParkingSpotStatus.EMPTY,parkingFloor,4))
        );
        parkingFloor.setStatus(ParkingFloorStatus.EMPTY);
        parkingFloor.setNumber(1);


        ParkingLot defaultPl = new ParkingLot(new ArrayList<>(List.of(parkingFloor)),
                new ArrayList<>(List.of(defaultGate)),
                new ArrayList<>(List.of(VehicleType.TWO_WHEELER, VehicleType.THREE_WHEELER, VehicleType.FOUR_WHEELER)),
                ParkingLotStatus.OPERATIONAL,
                SpotAssignmentStrategyType.RANDOM
        );
        defaultPl = ticketService.generateDefaultParkingLot(defaultPl);
//        System.out.println(defaultPl);


    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO jsonNode){
        IssueTicketResponseDTO responseDTO = new IssueTicketResponseDTO();
        try{
            Ticket ticket = ticketService.issueTicket(jsonNode.getVehicleNumber(),jsonNode.getVehicleType(), jsonNode.getOwnerName(), jsonNode.getGateId());
            responseDTO.setTicket(ticket);
            responseDTO.setMessage("Ticket Issued Successfully");
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
            responseDTO.setMessage(e.getMessage());
        }
        return responseDTO;
    }
}
