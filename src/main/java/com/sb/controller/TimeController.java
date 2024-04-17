package com.sb.controller;

import com.sb.service.TimeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TimeController {

    // Injecting TimeService dependency using constructor injection
    private final TimeService timeService;

    // Constructor for TimeController, receiving TimeService instance
    public TimeController(TimeService timeService){
        this.timeService = timeService;
    }

    // Endpoint mapping for GET requests to "/convertTime"
    // Accepts a request parameter named "time"
    @GetMapping("/convertTime")
    public String convertTime(@RequestParam(name ="time") String time){
        // Delegates time conversion logic to TimeService and returns the result
        return timeService.convertTimeToWords(time);
    }
}
