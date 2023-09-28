package muhammadFahishHaritsahJBusAF;

public class JBus
{
    
    public static void main(String[] args){
        /*Bus test = createBus();
        System.out.println(test.name);
        System.out.println(test.facility);
        System.out.println(test.price.price);
        System.out.println(test.capacity); */
        
        /* Payment testPayment = new Payment(1, 1, 1, "A", 1, "A", "A");
        Invoice testInvoice = new Invoice(2, 2, 2, "B");
        Station testStation = new Station(3, "C", City.DEPOK);
        System.out.println(testPayment.print());
        System.out.println(testInvoice.print());
        System.out.println(testStation.print()); */
        
        /* Review testReview = new Review(1, "23 August 2023", "Bad Quality");
        Price testPrice = new Price(100000, 20000);
        Station testDeparture = new Station(2, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya");
        Station testArrival = new Station(3, "Halte UI", City.JAKARTA, "Universitas Indonesia");
        Bus testBus = new Bus(1, "Busway", Facility.AC, testPrice, 50, BusType.REGULER, City.DEPOK, testDeparture, testArrival);
        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
        Rating testRating = new Rating();
        System.out.println(testReview);
        System.out.println(testBus);
        System.out.println(testAccount);
        System.out.println(testPrice);
        System.out.println(testRating); */
        
        Price[] unfilteredArray = new Price[5];
      for(int i = 0 ; i < unfilteredArray.length ; i++) {
          int j = 5000;
          unfilteredArray[i] = new Price((i  + 1) * j);
      }
      
      System.out.println("Price List");
      for(Price price : unfilteredArray){
          System.out.println(price.price);
      }
      
      System.out.println("Below 12000.0");
      System.out.println(Validate.filter(unfilteredArray, 12000, true));
      System.out.println("Above 10000.0");
      System.out.println(Validate.filter(unfilteredArray, 10000, false));
      
    }
    
    /* public static Bus createBus(){
        Price price = new Price(100000.0d, 5);
        Bus bus = new Bus("Samsung Bus", Facility.LCD_TV, price, 20);
        return bus;
    } */
    
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
