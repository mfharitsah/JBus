package muhammadFahishHaritsahJBusAF;

/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice
{
    //field
    private int busId;
    public String departureDate;
    public String busSeat;
    
    //constructor
    public Payment(int id, int buyerId, int renterId, String time, int busId, String departureDate, String busSeat){
        super(id, renterId, buyerId, time);
        
        this.busId = busId;
        this.departureDate = departureDate;
        this.busSeat = busSeat;
 
    }
    
    public Payment(int id, Account buyer, Renter renter, String time, int busId, String departureDate, String busSeat){
        super(id, buyer, renter, time);
        
        this.busId = busId;
        this.departureDate = departureDate;
        this.busSeat = busSeat;
    }
    
    //method
    public String toString(){
       String print = "ID : " + id + "\nBus ID : " + busId + "\nDeparture Date = " + departureDate + "\nBus Seat = " + busSeat ;
       return print;
    }
    
    public int getBusId(){
        return busId;
    }
}
