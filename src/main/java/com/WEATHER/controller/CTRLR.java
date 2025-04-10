package com.WEATHER.controller;

import com.WEATHER.pojo.Tourist;
import com.WEATHER.service.TouristImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class CTRLR
{
    //Focus: REST-API production and their testing
    //E.g. Other businesses may use this API's endpoints to process their tourist's data
    public CTRLR()
    {
        System.out.println ("http://localhost:8080/WEATHER/api/enroll");
        System.out.println ("http://localhost:8080/WEATHER/api/getAll");
        System.out.println ("http://localhost:8080/WEATHER/api/getID/0");
        System.out.println ("http://localhost:8080/WEATHER/api/update");
        System.out.println ("http://localhost:8080/WEATHER/api/updateID/0/0.0");
        System.out.println ("http://localhost:8080/WEATHER/api/deleteID/0");
    }
    
    @Autowired
    private TouristImpl service;

    @PostMapping("enroll")//Send data to DB-server(create/update resource)
    public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist)
    {
        //Invoke an API Tester for interfacing
        String msg = service.registerTourist (tourist);

        return new ResponseEntity<> (msg, HttpStatus.OK);
    }

    @GetMapping("getAll")//Request data from server(fetch resource)
    public ResponseEntity<?> getAllTourists()
    {
        List<Tourist> list = service.fetchAllTourists ();

        return new ResponseEntity<> (list, HttpStatus.OK);
    }

    @GetMapping("getID/{ID}")
    public ResponseEntity<?>getTouristById(@PathVariable("ID") Integer ID)
    {
        Tourist tourist=service.fetchTouristById (ID);

        return new ResponseEntity<> (tourist, HttpStatus.OK);
    }

    @PutMapping("update")//Updates entire record
    public ResponseEntity<String>updateData(@RequestBody Tourist tourist)
    {
        String status=service.updateData (tourist);

        return new ResponseEntity<> (status, HttpStatus.OK);
    }

    @PatchMapping("updateID/{ID}/{budget}")//Updates part of a record
    public ResponseEntity<?>updateById(@PathVariable("ID") Integer ID,@PathVariable("budget") Double budget)
    {
        String tourist = service.updateById (ID,budget);

        return new ResponseEntity<> (tourist, HttpStatus.OK);
    }

    @DeleteMapping("deleteID/{ID}")//Deletes a record
    public ResponseEntity<String>deleteById(@PathVariable("ID") Integer ID)
    {
        String tourist = service.deleteTouristById (ID);

        return new ResponseEntity<> (tourist, HttpStatus.OK);
    }
}

