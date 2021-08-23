package io.github.vikie1.portfolio;

import java.util.HashMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
//@CrossOrigin(origins = "https://victormwangi.netlify.app")
public class AliveCheckAPI {
    
    @RequestMapping(value="/hi", method=RequestMethod.GET)
    public HashMap<String, String> checkStatus() {
        HashMap<String, String> status = new HashMap<>();
        status.put("status", "alive");
        return status;
    }

    @GetMapping(value="/")
    public String getMethodName() {
        return new String("hi");
    }
    
    
}
