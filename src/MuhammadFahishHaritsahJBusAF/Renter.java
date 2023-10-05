package muhammadFahishHaritsahJBusAF;


/**
 * Write a description of class Renter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Renter extends Serializable
{
    //fields
    public String address;
    public String companyName;
    public int phoneNumber;
    
    public Renter(int id, String companyName){
        super(id);
        this.companyName = companyName;
        this.address = "";
        this.phoneNumber = 0;
    }
    
    public Renter(int id, String companyName, String address){
        super(id);
        this.companyName = companyName;
        this.address = address;
        this.phoneNumber = 0;
    }
    
    public Renter(int id, String companyName, int phoneNumber){
        super(id);
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = "";
    }
    
    public Renter(int id, String companyName, int phoneNumber, String address){
        super(id);
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
}
