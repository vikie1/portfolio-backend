package io.github.vikie1.portfolio;

import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
public class AliveCheckAPI {
    
    @RequestMapping(value="/hi", method=RequestMethod.GET)
    public HashMap<String, String> checkStatus() {
        HashMap<String, String> status = new HashMap<>();
        status.put("status", "alive");
        return status;
    }
    
}
