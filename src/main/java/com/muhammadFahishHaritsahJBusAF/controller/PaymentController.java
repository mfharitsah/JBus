package com.muhammadFahishHaritsahJBusAF.controller;

import com.muhammadFahishHaritsahJBusAF.*;
import com.muhammadFahishHaritsahJBusAF.dbjson.*;
import com.muhammadFahishHaritsahJBusAF.Account;
import com.muhammadFahishHaritsahJBusAF.Algorithm;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController implements BasicGetController {

    public static @JsonAutowired(value = Payment.class, filepath = "C:\\Users\\M Fahish HB\\Desktop\\Teknik Komputer UI\\Semester 3\\OOP\\Praktikum\\JBus Project\\JBus\\src\\main\\java\\com\\muhammadFahishHaritsahJBusAF\\json\\payments.json")
    JsonTable<Payment> paymentTable;

    static {
        try {
            paymentTable = new JsonTable<>(Payment.class, "C:\\Users\\M Fahish HB\\Desktop\\Teknik Komputer UI\\Semester 3\\OOP\\Praktikum\\JBus Project\\JBus\\src\\main\\java\\com\\muhammadFahishHaritsahJBusAF\\json\\payments.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public JsonTable<Payment> getJsonTable() {
        return paymentTable;
    }

    @RequestMapping(value = "/makeBooking", method = RequestMethod.POST)
    public BaseResponse<Payment> makeBooking(
            @RequestParam int buyerId,
            @RequestParam int renterId,
            @RequestParam int busId,
            @RequestParam List<String> busSeats,
            @RequestParam Timestamp departureDate
    ) {

        Account buyer = Algorithm.<Account>find(AccountController.accountTable, e -> e.id == buyerId);
        Account renter = Algorithm.<Account>find(AccountController.accountTable, e -> e.company.id == renterId);
        Bus bus = Algorithm.<Bus>find(BusController.busTable, e -> e.id == busId);

        if (buyer != null && bus != null) {
            if (Payment.makeBooking(departureDate, busSeats, bus)) {
                Payment createPayment = new Payment(buyer, renter.company, busId, busSeats, departureDate);
                createPayment.status = Invoice.PaymentStatus.WAITING;

                paymentTable.add(createPayment);
                return new BaseResponse<>(true, "Successfully make a book", createPayment);

            }

            return new BaseResponse<>(false, "Failed to make a book! Seat/s is already booked", null);
        }

        return new BaseResponse<>(false, "Buyer or Bus not found", null);
    }

    @RequestMapping(value = "getAllPayments", method = RequestMethod.GET)
    public List<Payment> getAllPayments(
            @RequestParam int accountId
    ){
        return Algorithm.<Payment>collect(getJsonTable(), payment -> payment.buyerId == accountId
        );
    }

    @RequestMapping(value = "/{id}/accept", method = RequestMethod.POST)
    public BaseResponse<Payment> accept(@PathVariable int id) {
        Payment currentPayment = Algorithm.<Payment>find(getJsonTable(), e -> e.id == id);

        if (currentPayment != null) {

            currentPayment.status = Invoice.PaymentStatus.SUCCESS;
            return new BaseResponse<Payment>(true, "Payment accepted", currentPayment);
        }

        return new BaseResponse<Payment>(false, "Failed accepting current payment", null);
    }

    @PostMapping("/{id}/cancel")
    public BaseResponse<Payment> cancel(@PathVariable int id) {
        Payment currentPayment = Algorithm.<Payment>find(getJsonTable(), e -> e.id == id);

        if (currentPayment != null) {
            currentPayment.status = Invoice.PaymentStatus.FAILED;
            return new BaseResponse<Payment>(true, "Payment canceled", currentPayment);
        }

        return new BaseResponse<Payment>(false, "Failed canceling current payment", null);

    }

}
