package com.muhammadFahishHaritsahJBusAF;

import java.util.regex.Pattern;
import com.muhammadFahishHaritsahJBusAF.dbjson.*;

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
    public String phoneNumber;

    private static final String REGEX_NAME = "^[A-Z][a-zA-Z0-9_]{3,19}$";
    private static final String REGEX_PHONE = "^[0-9]{9,12}$";

    
    public Renter(String companyName) {
        super();
        this.companyName = companyName;
        this.address = "";
        this.phoneNumber = "";
    }
    
    public Renter(String companyName, String phoneNumber){
        super();
        this.companyName = companyName;
        this.phoneNumber = phoneNumber;
        this.address = "";
    }
    
    public Renter(String companyName, String phoneNumber, String address){
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
