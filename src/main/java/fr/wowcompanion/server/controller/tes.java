package fr.wowcompanion.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tes {

    @GetMapping("/toto")
    public String toto(){
        return "Bonjour";
    }
    
}
