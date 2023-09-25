package muhammadFahishHaritsahJBusAF;

public class Account extends Serializable{
    
    //field
    public String email;
    public String name;
    public String password;
    
    public Account(int id, String name, String email, String password){
        super(id);
        this.email = email;
        this.password = password;
        this.name = name;
    }
     
    public String toString(){
        String print = "\nAccount : " + "\nEmail : " + email + "\nPassword : " + password + "\nName : " + name;
        return print;
    }
}