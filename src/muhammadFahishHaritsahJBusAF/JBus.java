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
    
    public static void main(String[] args){
//        // PT Modul 5
//        // Tes Pagination
//        Bus b = createBus();
//        List<Timestamp> listOfSchedules = new ArrayList<>();
//        listOfSchedules.add(Timestamp.valueOf("2023-7-18 15:00:00"));
//        listOfSchedules.add(Timestamp.valueOf("2023-7-20 12:00:00"));
//        listOfSchedules.add(Timestamp.valueOf("2023-7-22 10:00:00"));
//        listOfSchedules.add(Timestamp.valueOf("2023-7-26 12:00:00"));
//
//        listOfSchedules.forEach(b::addSchedule);
//        System.out.println("Page 1");
//        Algorithm.paginate(b.schedules, 0, 3, t -> true).forEach(System.out::println);
//        System.out.println("=====================================================");
//        System.out.println("Page 2");
//        Algorithm.paginate(b.schedules, 1, 3, t -> true).forEach(System.out::println);
//        System.out.println("=====================================================");
//
//        // Tes Booking
//        String msgSuccess = "Booking Success!";
//        String msgFailed = "Booking Failed";
//        // valid date, invalid seat = Booking Failed
//        Timestamp t1 = Timestamp.valueOf("2023-7-19 15:00:00");
//        System.out.println("\nMake booking at July 19, 2023 15:00:00 Seats: AF17 AF18");
//        System.out.println(Payment.makeBooking(t1, List.of("AF17", "AF18"), b)? msgSuccess : msgFailed);
//        // valid date, invalid seat = Booking Failed
//        Timestamp t2 = Timestamp.valueOf("2023-7-18 15:00:00");
//        System.out.println("Make booking at July 18, 2023 15:00:00 Seat AF26");
//        System.out.println(Payment.makeBooking(t2, "AF26", b)? msgSuccess : msgFailed);
//        // valid date, valid seat = Booking Success
//        System.out.println("Make booking at July 18, 2023 15:00:00 Seats: AF7 AF8");
//        System.out.println(Payment.makeBooking(t2, List.of("AF7", "AF8"), b)? msgSuccess : msgFailed);
//        // valid date, valid seat = Booking Success
//        Timestamp t3 = Timestamp.valueOf("2023-7-20 12:00:00");
//        System.out.println("Make booking at July 20, 2023 12:00:00 Seats: AF1 AF2");
//        System.out.println(Payment.makeBooking(t3, List.of("AF1", "AF2"), b)? msgSuccess : msgFailed);
//        // valid date, book the same seat = Booking Failed
//        System.out.println("Make booking at July 20, 2023 12:00:00 Seat AF1");
//        System.out.println(Payment.makeBooking(t3, "AF1", b)? msgSuccess : msgFailed);
//        // check if the data changed
//        System.out.println("\nUpdated Schedule");
//        Algorithm.paginate(b.schedules, 0, 4, t-> true).forEach(System.out::println);

        String filepath = "C:\\Users\\M Fahish HB\\Desktop\\Teknik Komputer UI\\Semester 3\\OOP\\Praktikum\\JBus Project\\JBus\\data\\station.json";
        Gson gson = new Gson();

        try {
            BufferedReader buffer = new BufferedReader(new FileReader(filepath));
            List<Station> stationjson = gson.fromJson(buffer, new TypeToken<List<Station>>() {}.getType());
            stationjson.forEach(e -> System.out.println(e.toString()));
            System.out.println();
            buffer.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }
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
