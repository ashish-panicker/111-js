package in.stackroute.gettingstartedspringdatajpah2.controllers;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    
    public IndexController() {
    }
    
    @GetMapping({"/","" ,"/index"})
    public ResponseEntity<Map<String, String>> index() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Welcome to Spring Boot and H2");
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    
}
