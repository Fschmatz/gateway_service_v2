package com.fschmatz.gateway_service_v2.controller;

import com.fschmatz.gateway_service_v2.entity.Gateway;
import com.fschmatz.gateway_service_v2.repository.GatewayRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class GatewayController {

    GatewayRepository repository;

    @GetMapping("/")
    public String login() {
        return "redirect:http://localhost:9090/login/";
    }

    @GetMapping("/homeAdmin")
    public String homePage() {
        return "homeAdmin";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

    public void saveLogs(String logtext){
        Gateway gatewaylog = new Gateway();
        gatewaylog.setLog(logtext);
        gatewaylog.toString();
    }


    @GetMapping("/logs")
    public ResponseEntity<List<Gateway>> getAll() {
        try {
            List<Gateway> items = new ArrayList<Gateway>();
            repository.findAll().forEach(items::add);
            if (items.isEmpty())
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

            return new ResponseEntity<>(items, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping
    public ResponseEntity<Gateway> create(@RequestBody Gateway gateway) {
        try {
            Gateway savedItem = repository.save(gateway);
            System.out.println(savedItem.toString());
            return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }
}