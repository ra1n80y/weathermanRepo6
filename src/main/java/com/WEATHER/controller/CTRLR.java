package com.WEATHER.controller;

import com.WEATHER.pojo.Tourist;
import com.WEATHER.service.TouristImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        System.out.println ("http://localhost:8080/WEATHER/api/idUpdate/0/0.0");
        System.out.println ("http://localhost:8080/WEATHER/api/deleteID/0");
    }

    //SL4J Logger obj
    private static final Logger logger= LoggerFactory.getLogger (CTRLR.class);

    @Autowired
    private TouristImpl service;

    @PostMapping("enroll")//Send data to server(create/update resource)
    public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist)
    {
        String msg = service.registerTourist (tourist);
        return new ResponseEntity<> (msg, HttpStatus.OK);
    }

    @GetMapping("getAll")//Request data from server(fetch resource)
    public ResponseEntity<?> getAllTourists()
    {
        logger.debug ("getAll REST endpoint called");

        logger.info ("fetchAllTourists() invoked");
        List<Tourist> list = service.fetchAllTourists ();

        logger.debug ("Request process complete");
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

