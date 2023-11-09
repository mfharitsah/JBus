package com.muhammadFahishHaritsahJBusAF;


/**
 * Write a description of class Station here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Station extends Serializable
{
    //fields
    public City city;
    public String stationName;
    public String address;
    
    public Station(String stationName, City city, String address){
        super();
        this.stationName = stationName;
        this.city = city;
        this.address = address;
    }
    
    public String toString(){
        String print = "\nID : " + id + "\nStation Name : " + stationName + "\n" + "City : " + city.toString() + "\nAddress : " + address.toString();
        return print;
    }
}
