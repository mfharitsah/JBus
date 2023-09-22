package muhammadFahishHaritsahJBusAF;

public class Account extends Serializable{
    
    //field
    public String email;
    public String name;
    public String password;
    
    public Account(int id, String name, String email, String password){
        super(id);
    }
    
}