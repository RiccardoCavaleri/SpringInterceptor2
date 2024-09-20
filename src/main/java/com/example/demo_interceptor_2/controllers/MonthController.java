package com.example.demo_interceptor_2.controllers;

import com.example.demo_interceptor_2.entities.Month;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/month")
public class MonthController {

    @GetMapping("/test2")
    //con @RequestAttribute recupero l'attributo 'month' dall'interceptor (MonthInterceptor)
    public Month getMonth(@RequestAttribute("month") Month month){
        //restituisco un oggetto Month che avrà risposta in formato JSON
        return month;
    }
}
