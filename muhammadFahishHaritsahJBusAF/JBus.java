package muhammadFahishHaritsahJBusAF;


/**
 * Write a description of class JBus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class JBus
{
    
    public static void main(String[] args){
            
            
    }
    
    public static int getBusId(){
        return 0;
    }
    
    public static String getBusName(){
        String bus = "Bus";
        return bus;
    }
    
    public static boolean isDiscount(){
        return true;
    }
    
    public static float getDiscountPercentage(int beforeDiscount, int afterDiscount){
        float percentage;
        if (beforeDiscount <= afterDiscount){
            percentage = 0.0f;
        } 
            percentage = (float)( (beforeDiscount - afterDiscount)/(float)beforeDiscount ) * 100;
        
        
        return percentage;
    }
    
    public static int getDiscountedPrice(int price, float discountPercentage){
        int discountedPrice;
        if (discountPercentage > 100.0f){ discountPercentage =  100.0f; }
 
        discountedPrice = (int)(price - (price * (discountPercentage/100)));
        
        return discountedPrice;
    }
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        int originalPrice = (int)(discountedPrice/(1 - discountPercentage*0.01));
        
        return originalPrice;
    }
    
    public static float getAdminFeePercentage(){
        return 0.05f;
    }
    
    public static int getAdminFee(int price){
        float admin = getAdminFeePercentage();
        int adminFee = (int)(price * admin);
        
        return adminFee;
    }
    
    public static int getTotalPrice(int price, int numberOfSeat){
        int adminFee = getAdminFee(price * numberOfSeat);
        int total = (price * numberOfSeat) + adminFee;
        
        return total;
    }
    
}
