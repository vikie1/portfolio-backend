package io.github.vikie1.portfolio;

import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AliveCheckAPI {
    @GetMapping("/hi")
    public HashMap<String, String> checkStatus() {
        HashMap<String, String> status = new HashMap<>();
        status.put("status", "alive");
        return status;
    }

}
