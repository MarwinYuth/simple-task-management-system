package com.assignment.simple_task_management_system;

import java.util.Map;

import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
    
    @GetMapping("/")
    public Map<String,String> home(){
        return Map.of("message","Knock Knock I'm home");
    }
}
