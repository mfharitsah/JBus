package muhammadFahishHaritsahJBusAF;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;  

public class Payment extends Invoice
{
    //field
    private int busId;
    public Calendar departureDate;
    public String busSeat;
    
    //constructor
    public Payment(int id, int buyerId, int renterId, int busId, String busSeat){
        super(id, renterId, buyerId);
        
        this.busId = busId;
        this.busSeat = busSeat;
        
        this.departureDate = Calendar.getInstance();
        departureDate.add(Calendar.DATE, 2);
    }
    
    public Payment(int id, Account buyer, Renter renter, int busId, String busSeat){
        super(id, buyer, renter);
        
        this.busId = busId;
        this.busSeat = busSeat;
        
        this.departureDate = Calendar.getInstance();
        departureDate.add(Calendar.DATE, 2);
    }
    
    //method    
    public String getDepartureInfo(){
       String print = "ID : " + id + "\nBus ID : " + busId + "\nDeparture Date = " + departureDate.getTime() + "\nBus Seat = " + busSeat ;
       return print;
    }
    
    public String getTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("'Formatted Date:' MMMM dd, yyyy HH:mm:ss");
        String formattedDate = formatter.format(departureDate.getTime());
        
        return formattedDate;
    }
    
    public int getBusId(){
        return busId;
    }
}
