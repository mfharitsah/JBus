package com.muhammadFahishHaritsahJBusAF.controller;

import com.muhammadFahishHaritsahJBusAF.Algorithm;
import com.muhammadFahishHaritsahJBusAF.dbjson.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

public interface BasicGetController <T extends Serializable> {
    public JsonTable<T> getJsonTable();

    @GetMapping("/page")
    public default List<T> getPage(
            @RequestParam int page,
            @RequestParam int pageSize
    ) {
        List<T> pageList = Algorithm.<T>paginate(getJsonTable(), page, pageSize, (e) -> {
            return true;
        });

        return pageList;
    }

    @GetMapping("/{id}")
    public default T getById(
            @PathVariable int id
    ){
        T byId = Algorithm.<T>find(getJsonTable(), (e) -> {
            return e.id == id;
        });

        return byId;
    }
}