package com.muhammadFahishHaritsahJBusAF;

import java.util.regex.Pattern;
import com.muhammadFahishHaritsahJBusAF.dbjson.*;

public class Account extends Serializable {
    
    //field
    public String email;
    public String name;
    public String password;
    public Renter company;
    public double balance;
    public static final String REGEX_EMAIL =
            "^[a-zA-Z0-9]+@[a-zA-Z_]+?\\.[a-zA-Z.]+[a-zA-Z]+$";
    public static final String REGEX_PASSWORD =
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    
    public Account(String name, String email, String password){
        super();
        this.email = email;
        this.password = password;
        this.name = name;
        this.balance = 0.0d;
        this.company = null;
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

    public boolean topUp(double amount) {
        if (amount > 0.0) {
            this.balance += amount;
            return true;
        }
        else return false;
    }

    public boolean topDown(double amount) {
        if (amount > 0.0) {
            this.balance -= amount;
            return true;
        } else  return false;
    }
     
    public String toString(){
        String print = "Name : " + name + "\nEmail : " + email + "\nPassword : " + password;
        return print;
    }
}