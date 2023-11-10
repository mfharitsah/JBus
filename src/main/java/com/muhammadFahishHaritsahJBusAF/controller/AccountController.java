package com.muhammadFahishHaritsahJBusAF.controller;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.muhammadFahishHaritsahJBusAF.Account;
import com.muhammadFahishHaritsahJBusAF.Algorithm;
import com.muhammadFahishHaritsahJBusAF.Renter;
import org.springframework.web.bind.annotation.*;
import com.muhammadFahishHaritsahJBusAF.dbjson.*;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/account")
public class AccountController implements BasicGetController<Account>
{
    public static @JsonAutowired (value = Account.class, filepath = "C:\\Users\\M Fahish HB\\Desktop\\Teknik Komputer UI\\Semester 3\\OOP\\Praktikum\\JBus Project\\JBus\\src\\main\\java\\com\\muhammadFahishHaritsahJBusAF\\json\\accounts_db.json")
        JsonTable<Account> accountTable;

    static {
        try {
            accountTable = new JsonTable<>(Account.class, "C:\\Users\\M Fahish HB\\Desktop\\Teknik Komputer UI\\Semester 3\\OOP\\Praktikum\\JBus Project\\JBus\\src\\main\\java\\com\\muhammadFahishHaritsahJBusAF\\json\\accounts_db.json");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    String index() { return "account page"; }

    @PostMapping("/register")
    BaseResponse<Account> register
            (
                    @RequestParam String name,
                    @RequestParam String email,
                    @RequestParam String password
            )
    {
        if (!name.isBlank() || !email.isBlank() || !password.isBlank()){
            Account regist = new Account(name, email, password);

            boolean accountExist = Algorithm.<Account>exists(accountTable, e -> e.email.equals(email));
            if (!regist.validate()) { return new BaseResponse<>(false, "Please input a valid email and password!", null); }
            if (!accountExist){

                regist = new Account(name, email, AccountController.hashingString(password));

                accountTable.add(regist);
                return new BaseResponse<>(true, "Successfully registered a new account", regist);
            } else {
                return new BaseResponse<>(false, "Failed to register a new account! Account already created", null);
            }
        }

        return new BaseResponse<>(false, "Failed to register a new account! Data input cannot be blank", null);
    }

    @PostMapping("/login")
    BaseResponse<Account> login(
            @RequestParam String email,
            @RequestParam String password
    ) {

        String hashedPassword = hashingString(password);

        for (Account acc : accountTable) {
            if (!acc.email.equals(email)) { return new BaseResponse<>(false, "Login failed! The email has not yet registered ", null); }
            if (!acc.password.equals(hashedPassword)) { return new BaseResponse<>(false, "Login failed! Password is incorrect", null); }

            return new BaseResponse<>(true, "Login success!", acc);
        }

        return null;
    }

    @PostMapping("/{id}/registerRenter")
    BaseResponse<Renter> registerRenter(
            @PathVariable int id,
            @RequestParam String companyName,
            @RequestParam String phoneNumber,
            @RequestParam String address
    ) {
        for (Account acc : accountTable) {
            if (acc.id == id && acc.company == null) {
                Renter renter = new Renter(companyName, phoneNumber, address);
                acc.company = renter;
                return new BaseResponse<>(true, "Successfully register renter!", renter);
            }
        }

        return new BaseResponse<>(false, "Failed to register renter! Account not found or already registered as a renter", null);
    }

    @PostMapping("/{id}/topUp")
    BaseResponse<Double> topUp(
            @PathVariable int id,
            @RequestParam double amount
    ) {
        for(Account acc : accountTable) {
            if(acc.id == id && acc.topUp(amount)) {
                return new BaseResponse<Double>(true, "Successfully adding account balance", amount);
            }
        }

        return new BaseResponse<Double>(false, "Failed to adding account balance! Account not found or amount is invalid", null);
    }

    @Override
    public JsonTable<Account> getJsonTable() {
        return accountTable;
    }

    public static String hashingString(String password) {
        StringBuilder hashedPassword = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] byte_array = md.digest();
            for (byte b : byte_array) {
                hashedPassword.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hashedPassword.toString();
    }

//    @GetMapping("/{id}")
//    String getById(@PathVariable int id) { return "account id " + id + " not found!"; }

}
