package muhammadFahishHaritsahJBusAF;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;  
import java.sql.Timestamp;

public class Payment extends Invoice
{
    //field
    private int busId;
    public Timestamp departureDate;
    public String busSeat;
    
    //constructor
    public Payment(int id, int buyerId, int renterId, int busId, String busSeat, Timestamp departureDate){
        super(id, renterId, buyerId);
        
        this.busId = busId;
        this.busSeat = busSeat;
        
        this.departureDate = departureDate;
    }
    
    public Payment(int id, Account buyer, Renter renter, int busId, String busSeat, Timestamp departureDate){
        super(id, buyer, renter);
        
        this.busId = busId;
        this.busSeat = busSeat;
        
        this.departureDate = departureDate;
    }
    
    //method    
    public String getDepartureInfo(){
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        String formattedDate = formatter.format(departureDate.getTime());
        
       String print = "\nID : " + id + "\nBus ID : " + busId + "\nDeparture Date = " + formattedDate + "\nBus Seat = " + busSeat ;
       return print;
    }
    
    public String getTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        String formattedDate = formatter.format(super.time.getTime());
        
        return formattedDate;
    }
    
    public int getBusId(){
        return busId;
    }
    
    public static boolean isAvailable(Timestamp departureSchedule, String seat, Bus bus){
        for (Schedule schedule : bus.schedules) {
            if (schedule.departureSchedule.equals(departureSchedule) && schedule.isSeatAvailable(seat)) {
                return true;
            }  
        }
        
        return false;
    }

    public static boolean makeBooking(Timestamp departureSchedule, String seat, Bus bus){
            for (Schedule schedule : bus.schedules) {
                if (schedule.departureSchedule.equals(departureSchedule) && schedule.isSeatAvailable(seat)){
                    schedule.bookSeat(seat);
                    return true;
                }
            }    
        
        return false;
    }
    
}
