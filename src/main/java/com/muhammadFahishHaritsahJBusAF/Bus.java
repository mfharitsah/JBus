package com.muhammadFahishHaritsahJBusAF;

import java.util.*;
import java.text.*;
import java.sql.Timestamp;
import com.muhammadFahishHaritsahJBusAF.dbjson.*;

/**
 * Creates a new Bus with an id, name, facility, price, and capacity
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bus extends Serializable {
    public String name;
    public Station arrival;
    public int capacity;
    public BusType busType;
    public List<Schedule> schedules;
    public Price price;
    public List<Facility> facility;
    public Station departure;
    public int accountId;

    // instance variables - replace the example below with your own
    public Bus(String name, int capacity, List<Facility> facility, BusType busType, Price price, Station departure, Station arrival) {
        super();
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.busType = busType;
        this.departure = departure;
        this.arrival = arrival;
        this.schedules = new ArrayList<>();
        this.facility = facility;
    }

    @Override
    public String toString() {
        String printLine = "Bus Details = " + " | ID : " + this.id + " | Name : " + this.name + " | Facility : " + this.facility + " | Price : " + price.toString() + " | Capacity : " + String.valueOf(capacity) + " | Bus Type : " + this.busType  + " | Departure : " + this.departure + " | Arrival : " + this.arrival + " | ";
        return printLine;
    }

    public void addSchedule(Timestamp timestamp) throws Exception {
        boolean isExisting = false;
        Schedule schedule = new Schedule(timestamp, capacity);
        for (Schedule sched : schedules) {
            if (sched.departureSchedule.equals(schedule.departureSchedule)) {
                isExisting = true;
            }
        }

        if (!isExisting) {
            schedules.add(schedule);
        }
    }
}
