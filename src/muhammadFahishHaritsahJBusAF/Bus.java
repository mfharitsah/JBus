package muhammadFahishHaritsahJBusAF;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.sql.Timestamp;

public class Bus extends Serializable {
    
    //field
    public String name;
    public Facility facility;
    public Price price;
    public int capacity;
    public Station departure;
    public Station arrival;
    public BusType busType;
    public City city;
    public List<Schedule> schedules;
    
    public Bus(String name, Facility facility, Price price, int capacity, BusType busType, City city, Station departure, Station arrival){
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
    
    //method
    public void addSchedule(Timestamp timestamp){
        boolean isExist = false;
        Schedule schedule = new Schedule(timestamp, capacity);
        for (Schedule sched : schedules){
            if (sched.departureSchedule.equals(schedule.departureSchedule)) {
                isExist = true;
            }
        }

        if (isExist){
            schedules.add(schedule);
        }
    }
    
    public boolean read(){
        return false;        
    }
    public Object write(){
        return null;
    }
    
    public String toString(){
        String print = "\nBus ID : " + id + "\nName : " + name + "\nFacility : " + facility.toString() + "" + price.toString() + "\nCapacity : " + capacity + "\n\nDeparture : " + departure.toString() + "\n\nArrival : " + arrival.toString() + "\n\nBus Type : " + busType.toString() + "\nCity : " + city.toString();
        return print;
    }
}
