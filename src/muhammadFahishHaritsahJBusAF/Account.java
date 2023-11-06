package muhammadFahishHaritsahJBusAF;

import java.util.regex.Pattern;

public class Account extends Serializable {
    
    //field
    public String email;
    public String name;
    public String password;
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9]+@[a-zA-Z]+(\\.[a-zA-Z]+)+$";
    public static final String REGEX_PASSWORD = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
    
    public Account(String name, String email, String password){
        super();
        this.email = email;
        this.password = password;
        this.name = name;
    }
    
    public boolean read(){
        return false;        
    }
    public Object write(){
        return null;
    }

    public boolean validate(){
        boolean emailCheck = Pattern.matches(REGEX_EMAIL, String.valueOf(email));
        boolean passwordCheck = Pattern.matches(REGEX_PASSWORD, String.valueOf(password));

        if(!emailCheck){
            System.out.println("Not Found!");
        }
        if(!passwordCheck){
            System.out.println("Not Found!");
        }

        return emailCheck && passwordCheck;
    }
     
    public String toString(){
        String print = "Name : " + name + "\nEmail : " + email + "\nPassword : " + password;
        return print;
    }
}