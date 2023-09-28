package muhammadFahishHaritsahJBusAF;

import java.util.ArrayList;


/**
 * Write a description of class Validate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Validate
{
    public static ArrayList filter(Price[] list, int value, boolean less){
        ArrayList<Double> arr = new ArrayList<Double>();
        
        for(Price priceVal : list){
            if (less == true && priceVal.price <= value){
                arr.add(priceVal.price);
            } else if(less == false && priceVal.price > value){
                arr.add(priceVal.price);
            }
        }   
    
    return arr;
    }
}
