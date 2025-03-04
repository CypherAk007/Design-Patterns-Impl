package parkinglot_redo.services;

import parkinglot_redo.Stratiges.priceCalcStrategy.PriceCalculationStrategy;
import parkinglot_redo.exceptions.PaymentFailedException;
import parkinglot_redo.exceptions.VehicleNotFoundException;
import parkinglot_redo.factory.PriceAssignmentFactory;
import parkinglot_redo.models.*;
import parkinglot_redo.repositories.BillRepository;
import parkinglot_redo.repositories.VehicleRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BillGenService {
    private VehicleRepository vehicleRepository;
    private BillRepository billRepository;
    public BillGenService(VehicleRepository vehicleRepository,BillRepository billRepository){
        this.vehicleRepository = vehicleRepository;
        this.billRepository = billRepository;
    }


    public Bill generateBill(Ticket ticket,PaymentMode paymentMode){
//        validate the ticket
//        price : based on vehicle type
//        System.out.println("Bill gen service : generatebill vehicle found");
        Vehicle vehicle = ticket.getVehicle();
        Optional<Vehicle> vehicleOptional = vehicleRepository.findByVehicleNumber(vehicle.getVehicleNumber());
        if(vehicleOptional.isEmpty()){
            throw new VehicleNotFoundException();
        }

        Date entryTime = ticket.getEntryTime();
        VehicleType vehicleType = ticket.getVehicle().getType();
        PriceCalculationStrategy priceCalculationStrategy = PriceAssignmentFactory.getPriceAssignmentStrategyBasedOnVehicleType(vehicleType);
        int price = priceCalculationStrategy.calculatePrice(entryTime);
//        System.out.println("Price : "+price);

        Payment payment = makePayment(price,paymentMode);
        if(payment.getStatus().equals(PaymentStatus.UNPAID)){
            throw new PaymentFailedException();
        }
        Bill bill = new Bill(ticket);
        bill.setExitTime(new Date());
        bill.setAmount(price);
        bill.setCollectedAt(ticket.getGeneratedAt());
        bill.setCollectedBy(ticket.getGeneratedBy());
        bill.setStatus(BillStatus.PAID);
        bill.setPayments(new ArrayList<>(List.of(payment)));
        bill = billRepository.save(bill);
        System.out.println("Bill Is Generated : "+bill);
        bill.display();
        return bill;
    }

    private Payment makePayment(int amount,PaymentMode paymentMode){
        //logic to get payment and ack - To be Implemented
        return new Payment(paymentMode,amount,PaymentStatus.PAID,"#RAZ00112233",new Date());

    }




}


//price generation
//Bill calculation for a vehicle depends upon to two things, time spent in the parking lot and the type of vehicle.
// Refer the below tables to understand pricing. For BIKEs: Hours spent Price per hour 0-2 20 2-4 25 4-6 30 6 onwards 40
//
//For CARs: Hours spent Price per hour 0-2 25 2-4 30 4-6 35 6 onwards 45
//
//For TRUCKs: Hours spent Price per hour 0-2 50 2-4 60 4-6 65 6 onwards 80
//
//For eg. If a car spends 5.5 hours in the parking lot then their final bill
// will be: 2 * 25 (Charge for first 2 hours) + 2 * 30 (Charge for the next two hours i.e hour 3 and hour 4) +
// 2 * 35 (Charge for 5th hour and 6th hour (Note: even tough the vehicle was not in the parking lot for the entire hour,
// we charged it for the entire hour)) = Rs. 180 Note: This is one way of charging customers, in the future we might change this.
