```commandline
 :::  ===  === :::===== :::      :::===== :::====  :::=======  :::=====      :::==== :::====       :::====  :::  === :::====  :::====  :::      :::=======  :::====  :::      :::          
 :::  ===  === :::      :::      :::      :::  === ::: === === :::           :::==== :::  ===      :::  === :::  === :::  === :::  === :::      ::: === === :::  === :::      :::          
 ===  ===  === ======   ===      ===      ===  === === === === ======          ===   ===  ===      ===  === ===  === =======  ======== ===      === === === ======== ===      ===          
  ===========  ===      ===      ===      ===  === ===     === ===             ===   ===  ===      ===  === ===  === ===  === ===  === ===      ===     === ===  === ===      ===          
   ==== ====   ======== ========  =======  ======  ===     === ========        ===    ======       =======   ======  =======  ===  === ===      ===     === ===  === ======== ========     
                                                                                                                                                                                           
                                              :::====  :::====  :::====  :::  === ::: :::= === :::=====       :::      :::====  :::====                                                    
                                              :::  === :::  === :::  === ::: ===  ::: :::===== :::            :::      :::  === :::====                                                    
                                              =======  ======== =======  ======   === ======== === =====      ===      ===  ===   ===                                                      
                                              ===      ===  === === ===  === ===  === === ==== ===   ===      ===      ===  ===   ===                                                      
                                              ===      ===  === ===  === ===  === === ===  ===  =======       ========  ======    ===                                                      
                                                                                                                                                                                           
Parking Spot Found: ParkingSpot{vehicleType=[TWO_WHEELER], status=EMPTY, floor=ParkingFloor{, status=EMPTY, number=1}, spotNumber=1}
Generated Ticket : 
+---------------------------------------------+
|  Ticket Invoice                             |
|  Ticket# 1                                  |
|  Entry Time : Tue Mar 04 17:41:06 IST 2025  |
|  Assigned Spot : Floor#1 Spot#1,            |
|  Issuer : Ak - 0                            |
|  Have a Nice Day!!                          |
+---------------------------------------------+
IssueTicketResponseDTO{ticket=Ticket{entryTime=Tue Mar 04 17:41:06 IST 2025, assignedSpot=ParkingSpot{vehicleType=[TWO_WHEELER], status=OCCUPIED, floor=ParkingFloor{, status=EMPTY, number=1}, spotNumber=1}, number='Ticket# 1', generatedAt=null, generatedBy=Operator{name='Ak'}, vehicle=Vehicle{ownerName='Abhishek', type=TWO_WHEELER, vehicleNumber='RC007EX8055'}}, message='Ticket Issued Successfully', responseStatus=SUCCESS}
Bill for ::Ticket{entryTime=Tue Mar 04 17:41:06 IST 2025, assignedSpot=ParkingSpot{vehicleType=[TWO_WHEELER], status=OCCUPIED, floor=ParkingFloor{, status=EMPTY, number=1}, spotNumber=1}, number='Ticket# 1', generatedAt=null, generatedBy=Operator{name='Ak'}, vehicle=Vehicle{ownerName='Abhishek', type=TWO_WHEELER, vehicleNumber='RC007EX8055'}}
Total Time Parked : 00:00:00.033
Bill Is Generated : Bill{exitTime=Tue Mar 04 17:41:06 IST 2025, billNuber=1, ticket=Ticket{entryTime=Tue Mar 04 17:41:06 IST 2025, assignedSpot=ParkingSpot{vehicleType=[TWO_WHEELER], status=OCCUPIED, floor=ParkingFloor{, status=EMPTY, number=1}, spotNumber=1}, number='Ticket# 1', generatedAt=null, generatedBy=Operator{name='Ak'}, vehicle=Vehicle{ownerName='Abhishek', type=TWO_WHEELER, vehicleNumber='RC007EX8055'}}, amount=40.0, collectedAt=null, collectedBy=Operator{name='Ak'}, status=PAID, payments=[parkinglot_redo.models.Payment@f2a0b8e]}
+--------------------------------------------+
|  Bill Invoice                              |
|  Bill#1                                    |
|  Ticket#Ticket# 1                          |
|  Exit Time : Tue Mar 04 17:41:06 IST 2025  |
|  Total Amount Paid: 40.0                   |
|  PaymentRef No. : #RAZ00112233             |
|  Issuer : Ak - 0                           |
|  Thank You!! Visit Again!!                 |
+--------------------------------------------+
IssueBillResponseDTO{bill=Bill{exitTime=Tue Mar 04 17:41:06 IST 2025, billNuber=1, ticket=Ticket{entryTime=Tue Mar 04 17:41:06 IST 2025, assignedSpot=ParkingSpot{vehicleType=[TWO_WHEELER], status=OCCUPIED, floor=ParkingFloor{, status=EMPTY, number=1}, spotNumber=1}, number='Ticket# 1', generatedAt=null, generatedBy=Operator{name='Ak'}, vehicle=Vehicle{ownerName='Abhishek', type=TWO_WHEELER, vehicleNumber='RC007EX8055'}}, amount=40.0, collectedAt=null, collectedBy=Operator{name='Ak'}, status=PAID, payments=[parkinglot_redo.models.Payment@f2a0b8e]}, message='Bill Issued Successfully', responseStatus=SUCCESS}


## Class Diagram
class BaseModel {

  attributes:
    id: long
    createdBy: String
    createdAt: Date
    updatedBy: String
    updatedAt: Date

  methods:
    // @Getters and @Setters for above Attributes 

}

class ParkingLot extends BaseModel {

  attributes:
    floors:List<ParkingFloor>
    gates: List<Gate>
    allowedVehicleTypes: List<VehicleType> 
    status:ParkingLotStatus
    spotAssignmentStrategyType: SpotAssignmentStrategyType
    feeCalculationStrategyType: FeeCalculationStrategyType

  methods:
    // @Getters and @Setters for above Attributes 

}

class ParkingFloor extends BaseModel{

  attributes:
    parkingSpots:List<ParkingSpot> 
    status:ParkingFloorStatus
    number:int


  methods:
  // @Getters and @Setters for above Attributes 

}

class ParkingSpot extends BaseModel {

  attributes:
    vehicleType:List<VehicleType> 
    status:ParkingSpotStatus
    floor:ParkingFloor 
    spotNumber:int

  methods:
    // @Getters and @Setters for above Attributes 

}
class Bill extends BaseModel {

  attributes:
    exitTime:Date
    billNuber:long
    ticket:Ticket
    amount:double
    collectedAt:Gate
    collectedBy:Operator
    status:BillStatus
    payments:List<Payment>

  methods:
    // @Getters and @Setters for above Attributes 
    display():void

}

class ParkingSpot extends BaseModel {

  attributes:
    vehicleType:List<VehicleType> 
    status:ParkingSpotStatus
    floor:ParkingFloor 
    spotNumber:int

  methods:
    // @Getters and @Setters for above Attributes 

}

class Gate extends BaseModel {

  attributes:
    gateNumber:long
    gateStatus:GateStatus
    currentOperator:Operator
    type:GateType

  methods:
    // @Getters and @Setters for above Attributes 

}

class Operator extends BaseModel {

  attributes:
    name:String

  methods:
    // @Getters and @Setters for above Attributes 

}

class Payment extends BaseModel {

  attributes:
    paymentMode:PaymentMode ;
    amount:double ;
    status:PaymentStatus ;
    referenceNumber: String ;
    time:Date ;

  methods:
    // @Getters and @Setters for above Attributes 

}


class Ticket extends BaseModel {

  attributes:
    entryTime:Date ;
    assignedSpot:ParkingSpot ;
    number:String ;
    generatedAt:Gate ;
    generatedBy:Operator ;
    vehicle:Vehicle ;


  methods:
    // @Getters and @Setters for above Attributes 
    display():void

}

# Controllers
class BillController {

  attributes:
    billGenService:BillGenService ;

  methods:
    // DependencyInjection for above Attributes 
     issueBill(IssueBillRequestDTO requestDTO):IssueBillResponseDTO

}

# Controllers
class TicketController {

  attributes:
    ticketService:TicketService ;

  methods:
    // DependencyInjection for above Attributes 
     issueTicket(IssueTicketRequestDTO requestDTO):IssueTicketResponseDTO

}

# Service
class BillGenService {

  attributes:
    vehicleRepository:VehicleRepository ;
    billRepository:BillRepository;

  methods:
    // DependencyInjection for above Attributes 
    generateBill(Ticket ticket,PaymentMode paymentMode):Bill
    makePayment(int amount,PaymentMode paymentMode):Payment

}

# Service
class TicketService {

  attributes:
    vehicleRepository:VehicleRepository ;
    billRepository:BillRepository;
    ticketRepository:TicketRepository ;
    parkingLotRepository:ParkingLotRepository ;

  methods:
    // DependencyInjection for above Attributes 
    issueTicket(String vehicleNumber, VehicleType vehicleType,String ownerName,long gateId):Ticket
    createNewVehicleEntry(String vehicleNumber, VehicleType vehicleType, String ownerName) :Vehicle
    generateDefaultGate(Gate gate):Gate
    generateDefaultParkingLot(ParkingLot parkingLot):ParkingLot

}


enum ParkingFloorStatus {
    OPERATIONAL,
    UNDER_MAINTENANCE,
    RESTRICTED,
    FILLED,
    EMPTY
}
enum VehicleType {
    TWO_WHEELER,THREE_WHEELER,FOUR_WHEELER
}

enum BillStatus {
    PAID,UNPAID
}

enum FeeCalculationStrategyType {
    BASED_ON_VEHICLE_TYPE,
    FIXED,
    BASED_ON_TIME,
    BASED_ON_TIME_AND_VEHICLE_TYPE,
}

enum GateStatus {
    OPEN,
    CLOSED
}

enum GateType {
    ENTRY,EXIT
}

enum ParkingLotStatus {
    OPERATIONAL,UNDER_MAINTENANCE,COMPLETELY_FILLED
}

enum ParkingSpotStatus {
    EMPTY,OCCUPIED
}

enum PaymentMode {
    OFFLINE,ONLINE
}


enum PaymentStatus {
    PAID,UNPAID
}

enum SpotAssignmentStrategyType {
    NEAREST_FIRST,
    RANDOM
}


Design patterns

1. DTO is Implemented for client to intract with our system to support backward compatibality.
2. Strategy Pattern for PriceCalculation basedon vehicle type and Implemented using Interfaces
3. Strategy Pattern for SpotAssignmentStrategy (RANDOM,...) based on and Implemented using Interfaces
4. The whole Parking lot is built on MVC Architecture. And Client Contract is TicketController,BillController.

```