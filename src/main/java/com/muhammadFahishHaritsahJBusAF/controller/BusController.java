package com.muhammadFahishHaritsahJBusAF.controller;

import com.fasterxml.jackson.databind.ser.Serializers;
import com.muhammadFahishHaritsahJBusAF.*;
import org.springframework.web.bind.annotation.*;
import com.muhammadFahishHaritsahJBusAF.dbjson.*;
import com.muhammadFahishHaritsahJBusAF.Account;
import com.muhammadFahishHaritsahJBusAF.Algorithm;
import java.sql.Timestamp;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController implements BasicGetController<Bus> {

    public static @JsonAutowired(value = Bus.class, filepath = "C:\\Users\\M Fahish HB\\Desktop\\Teknik Komputer UI\\Semester 3\\OOP\\Praktikum\\JBus Project\\JBus\\src\\main\\java\\com\\muhammadFahishHaritsahJBusAF\\json\\buses.json")
    JsonTable<Bus> busTable;

    static {
        try {
            busTable = new JsonTable<>(Bus.class, "C:\\Users\\M Fahish HB\\Desktop\\Teknik Komputer UI\\Semester 3\\OOP\\Praktikum\\JBus Project\\JBus\\src\\main\\java\\com\\muhammadFahishHaritsahJBusAF\\json\\buses.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public JsonTable<Bus> getJsonTable() {
        return busTable;
    }

    @PostMapping("/create")
    public BaseResponse<Bus> create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int capacity,
            @RequestParam List<Facility> facilities,
            @RequestParam BusType busType,
            @RequestParam int price,
            @RequestParam int stationDepartureId,
            @RequestParam int stationArrivalId
    ) {

//       Account newacc = Algorithm.<Account>find(AccountController.accountTable, newaccount -> newaccount.id == accountId && newaccount.company != null);
        for (Account acc : AccountController.accountTable) {
            if (acc.id == accountId && acc.company != null) {

                Station departure = Algorithm.<Station>find(StationController.stationTable, station -> station.id == stationDepartureId);
                Station arrival = Algorithm.<Station>find(StationController.stationTable, station -> station.id == stationArrivalId);
                if (departure != null && arrival != null) {

                        Bus createBus = new Bus(accountId, name, capacity, facilities, busType, new Price(price), departure, arrival);
                    System.out.println(busTable);
                        busTable.add(createBus);
                        return new BaseResponse<>(true, "Successfully created new bus!", createBus);

                    }
                    return new BaseResponse<>(false, "Failed to create new bus! Departure station or arrival invalid", null);


            }
        }

        return new BaseResponse<>(false, "Account not found or not registered as a renter", null);
    }

    @PostMapping("/addSchedule")
    public BaseResponse<Bus> addSchedule(
            @RequestParam int busId,
            @RequestParam Timestamp time
    ) {
        Bus theBus = Algorithm.<Bus>find(busTable, e -> e.id == busId);
        if (theBus == null) {
            return new BaseResponse<>(false, "ID invalid! Bus not found", null);
        }

        try {
            theBus.addSchedule(time);
            return new BaseResponse<>(true, "Successfully adding schedule", theBus);
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResponse<>(false, "Failed to add new schedule", null);
        }
    }

    @GetMapping("/getMyBus")
    public BaseResponse<List<Bus>> getMyBus(
            @RequestParam int accountId
    ) {
        return new BaseResponse<>(true, "Successfullly get MyBus", Algorithm.<Bus>collect(getJsonTable(),
                b -> b.accountId==accountId)
        );
    }

    @GetMapping("/getAllBus")
    public List<Bus> getAllBus() {
        return Algorithm.<Bus>collect(getJsonTable(), b -> true
        );
    }

}
