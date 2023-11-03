package muhammadFahishHaritsahJBusAF;

import java.util.Calendar;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class JBus
{

    public static void main(String[] args) {
//        try {
//            String filepath = "C:\\Users\\M Fahish HB\\Desktop\\Teknik Komputer UI\\Semester 3\\OOP\\Praktikum\\JBus Project\\JBus\\data\\buses.json";
//            JsonTable<Bus> busList = new JsonTable<>(Bus.class, filepath);
//            List<Bus> filteredBus =
//                    filterByDeparture(busList, City.JAKARTA, 0, 3);
//            filteredBus.forEach(bus -> System.out.println(bus.toString()));
//        } catch (Throwable t) {
//            t.printStackTrace();
//        }

        //Filter by Price
//        System.out.println("\n\nFilter by Price");
//        try {
//            String filepath = "C:\\Users\\M Fahish HB\\Desktop\\Teknik Komputer UI\\Semester 3\\OOP\\Praktikum\\JBus Project\\JBus\\data\\buses_CS.json";
//            JsonTable<Bus> busList = new JsonTable<>(Bus.class, filepath);
//            List<Bus> filteredBus =
//                    filterByPrice(busList, 100000, 500000);
//            filteredBus.forEach(bus -> System.out.println(bus.toString()));
//        } catch (Throwable t) {
//            t.printStackTrace();
//        }

        System.out.println("\n\nFilter by Price");
        try {
            String filepath = "C:\\Users\\M Fahish HB\\Desktop\\Teknik Komputer UI\\Semester 3\\OOP\\Praktikum\\JBus Project\\JBus\\data\\buses_CS.json";
            JsonTable<Bus> busList = new JsonTable<>(Bus.class, filepath);
            Bus filteredBus = filterBusId(busList, 155);
            System.out.println(filteredBus);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static List<Bus> filterByDeparture(List<Bus> buses, City departure, int page, int pageSize) {
        List<Bus> list = new ArrayList<>();

        for(Bus bus : buses) {
            if(bus.departure.city == departure) {
                list.add(bus);
            }
        }

        List<Bus> pageList = Algorithm.paginate(list, page, pageSize, (e) -> {
            return true;
        });

        return pageList;
    }

    public static List<Bus> filterByPrice(List<Bus> buses, int min, int max)
    {
        return Algorithm.<Bus>collect(buses, (e) -> e.price.price >= min && e.price.price <= max);
//        List<Bus> filtered = new ArrayList<>();
//
//        for(Bus bus : buses){
//            if(bus.price.price >= min && bus.price.price <= max){
//                filtered.add(bus);
//            }
//        }
//
//        return filtered;
    }

    public static Bus filterBusId(List<Bus> buses, int id){
        return Algorithm.<Bus>find(buses, (e) -> {
            return e.id == id;
        });
    }

    public static List<Bus> filterByDepartureAndArrival(List<Bus> buses, City departure, City arrival, int page, int pageSize){
        return Algorithm.<Bus>collect(buses, (e) -> {
            return e.arrival.city == arrival && e.departure.city == departure;
        });
    }

    private static void testExist(Integer[] t) {
        int valueToCheck = 67;
        boolean result3 = Algorithm.exists(t, valueToCheck);
        if (result3) {
            System.out.println(valueToCheck + " exist in the array.");
        } else {
            System.out.println(valueToCheck + " doesn't exists in the array.");
        }
    }

    public static void testCount(Integer[] t) {
        int valueToCount = 18;
        int result = Algorithm.count(t, valueToCount);
        System.out.println("Number " + valueToCount + " appears " + result + " times");
    }

    public static void testFind(Integer[] t) {
        Integer valueToFind = 69;
        Integer result2 = Algorithm.find(t, valueToFind);
        System.out.print("Finding " + valueToFind + " inside the array : ");
        if (result2 != null) {
            System.out.println("Found!" + result2);
        } else {
            System.out.println("Not Found");
        }
    }
    private static void testCollect(Integer[] t) {
        Predicate<Integer> below = (val)->val<=22;
        Predicate<Integer> above = (val)->val>43;

        List<Integer> integerBelow = Algorithm.collect(t, below);
        List<Integer> integerAbove = Algorithm.collect(t, above);

        System.out.println("Below 22");
        System.out.println(integerBelow);
        System.out.println("Above 43");
        System.out.println(integerAbove);
    }
    
    public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus("Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station("Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station("Halte UI", City.JAKARTA, "Universitas Indonesia"));
        return bus;
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
