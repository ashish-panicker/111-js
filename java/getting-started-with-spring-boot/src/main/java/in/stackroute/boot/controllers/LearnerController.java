package in.stackroute.boot.controllers;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import in.stackroute.boot.domain.Learner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class LearnerController {

    private static List<Learner> learners = new ArrayList<>();

   
    @PostMapping("/learners")
    public List<Learner> create(@RequestBody Learner learner) {
        System.err.println(learner);
        learners.add(learner);
        return learners;
    }

    @GetMapping("/learners")
    public List<Learner> findAll() {
        return learners;
    }
    
}
