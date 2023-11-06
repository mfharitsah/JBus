package muhammadFahishHaritsahJBusAF;

import java.util.*;
import java.text.*;
import java.sql.Timestamp;

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
    public City city;
    public Price price;
    public Facility facility;
    public Station departure;

    // instance variables - replace the example below with your own
    public Bus(String name, Facility facility, Price price, int capacity, BusType busType, City city, Station departure, Station arrival) {
        super();
        this.name = name;
        this.facility = facility;
        this.price = price;
        this.capacity = capacity;
        this.busType = busType;
        this.city = city;
        this.departure = departure;
        this.arrival = arrival;
        this.schedules = new ArrayList<>();
    }

    @Override
    public String toString() {
        String printLine = "Bus Details = " + " | ID : " + this.id + " | Name : " + this.name + " | Facility : " + this.facility + " | Price : " + price.toString() + " | Capacity : " + String.valueOf(capacity) + " | Bus Type : " + this.busType + " | City : " + this.city + " | Departure : " + this.departure + " | Arrival : " + this.arrival + " | ";
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
