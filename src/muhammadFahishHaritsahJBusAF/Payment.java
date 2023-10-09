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
    public Payment(int buyerId, int renterId, int busId, String busSeat, Timestamp departureDate){
        super(renterId, buyerId);
        
        this.busId = busId;
        this.busSeat = busSeat;
        
        this.departureDate = departureDate;
    }
    
    public Payment(Account buyer, Renter renter, int busId, String busSeat, Timestamp departureDate){
        super(buyer, renter);
        
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


    public Schedule availableSchedule(Timestamp departureSchedule, String seat, Bus bus){
        return departureSchedule;
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
