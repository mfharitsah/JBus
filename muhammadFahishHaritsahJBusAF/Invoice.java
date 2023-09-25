package muhammadFahishHaritsahJBusAF;


/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Invoice extends Serializable
{
   //fields
   public String time;
   public int buyerId;
   public int renterId;
   public BusRating rating;
   public PaymentStatus status;
   
   //enum
   public enum BusRating{
       NONE,
       NEUTRAL,
       GOOD,
       BAD;
   }
   
   public enum PaymentStatus{
       FAILED,
       WAITING,
       SUCCESS;
   }
   
   protected Invoice(int id, int buyerId, int renterId, String time){
       super(id);
       this.buyerId = buyerId;
       this.renterId = renterId;
       this.time = time;
       this.rating = BusRating.NONE;
       this.status = PaymentStatus.WAITING;
   }
   
   public Invoice(int id, Account buyer, Renter renter, String time){
       super(id);
       this.buyerId = buyer.id;
       this.renterId = renter.id;
       this.time = time;
       this.rating = BusRating.NONE;
       this.status = PaymentStatus.WAITING;
   }
   
   //method
   public String toString(){
       String print = "ID : " + id + "\nTime : " + time + "\nBuyer ID = " + buyerId + "\nRenter ID = " + renterId;
       return print;
   }
}