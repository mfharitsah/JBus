package muhammadFahishHaritsahJBusAF;


import java.util.regex.Pattern;

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

    private final String REGEX_NAME = "^[A-Z][a-zA-Z0-9_]{3,19}$";
    private final String REGEX_PHONE = "^[0-9]{9,12}$";

    
    public Renter(String companyName){
        super();
        this.companyName = companyName;
        this.address = "";
        this.phoneNumber = 0;
    }
    
    public Renter(String companyName, String address){
        super();
        this.companyName = companyName;
        this.address = address;
        this.phoneNumber = 0;
    }
    
    public Renter(String companyName, int phoneNumber){
        super();
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = "";
    }
    
    public Renter(String companyName, int phoneNumber, String address){
        super();
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public boolean validate(){
        boolean name = Pattern.matches(REGEX_NAME, String.valueOf(companyName));
        boolean phone = Pattern.matches(REGEX_PHONE, String.valueOf(phoneNumber));

        if(!name){
            System.out.println("Not Found!");
        }
        if(!phone){
            System.out.println("Not Found!");
        }

        return name && phone;
    }
}
