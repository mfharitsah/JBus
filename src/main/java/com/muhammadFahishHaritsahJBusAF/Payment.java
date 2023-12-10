package com.muhammadFahishHaritsahJBusAF;

import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.List;

public class Payment extends Invoice {
    //field
    private int busId;
    public Timestamp departureDate;
    public List<String> busSeat;

    //constructor
    public Payment(int buyerId, int renterId, int busId, List<String> busSeat, Timestamp departureDate) {
        super(renterId, buyerId);

        this.busId = busId;
        this.busSeat = busSeat;

        this.departureDate = departureDate;
    }

    public Payment(Account buyer, Renter renter, int busId, List<String> busSeat, Timestamp departureDate) {
        super(buyer, renter);

        this.busId = busId;
        this.busSeat = busSeat;

        this.departureDate = departureDate;
    }

    //method    
    public String getDepartureInfo() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String formattedDate = formatter.format(departureDate.getTime());

        String print = "\nID : " + id + "\nBus ID : " + busId + "\nDeparture Date = " + formattedDate + "\nBus Seat = " + busSeat;
        return print;
    }

    public int getBusId() {
        return busId;
    }
    public static Schedule availableSchedule(Timestamp schedule, String seat, Bus bus) {
        for (Schedule string : bus.schedules) {
            if (string.departureSchedule == schedule) {
                if (string.isSeatAvailable(seat)) {
                    return string;
                }
            }
        }
        return null;
    }

    public static Schedule availableSchedule(Timestamp schedule, List<String> seat, Bus bus) {
        for (Schedule string : bus.schedules) {
            if (string.departureSchedule.equals(schedule)) {
                if (string.isSeatAvailable(seat)) {
                    return string;
                }
            }
        }
        return null;
    }

    public static boolean makeBooking(Timestamp departureSchedule, String seat, Bus bus) {
        for (Schedule schedule : bus.schedules) {
            if (schedule.departureSchedule.equals(departureSchedule) && schedule.isSeatAvailable(seat)) {
                schedule.bookSeat(seat);
                return true;
            }
        }

        return false;
    }

    public static boolean makeBooking(Timestamp departureSchedule, List<String> seat, Bus bus) {
        for (Schedule schedule : bus.schedules) {
            if (schedule.departureSchedule.equals(departureSchedule) && schedule.isSeatAvailable(seat)) {
                schedule.bookSeat(seat);
                return true;
            }
        }

        return false;
    }

}
