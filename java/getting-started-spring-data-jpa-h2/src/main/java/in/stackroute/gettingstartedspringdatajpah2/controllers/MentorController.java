package in.stackroute.gettingstartedspringdatajpah2.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import in.stackroute.gettingstartedspringdatajpah2.domain.Mentor;
import in.stackroute.gettingstartedspringdatajpah2.dto.MentorDto;
import in.stackroute.gettingstartedspringdatajpah2.exceptions.MentorNotFoundException;
import in.stackroute.gettingstartedspringdatajpah2.exceptions.NoSuchMentorException;
import in.stackroute.gettingstartedspringdatajpah2.service.MentorService;

@RestController
public class MentorController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    private MentorService mentorService;

    private ModelMapper modelMapper;

    private Map<Object, Object> response;

    public MentorController(MentorService mentorService, ModelMapper modelMapper) {
        this.mentorService = mentorService;
        this.modelMapper = modelMapper;
        response = new HashMap<>();
    }

    // Post request to create a new mentor
    // on successful creation of mentor, return the created mentor with status code 201
    @PostMapping("/mentors")
    public ResponseEntity<Map<?, ?>> createMentor(@RequestBody @Valid MentorDto mentorDto) {
        log.debug("CREATING A NEW MENTOR: " + mentorDto);
        Mentor mentor = modelMapper.map(mentorDto, Mentor.class);
        mentor = mentorService.create(mentor);
        mentorDto = modelMapper.map(mentor, MentorDto.class);
        log.debug("CREATED A NEW MENTOR: ID = " + mentorDto.getId());
        response.put("status", HttpStatus.CREATED);
        response.put("response", mentorDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Get request to fetch all mentors
    @GetMapping("/mentors")
    public ResponseEntity<Map<Object, Object>> getAllMentors() {
        response = new HashMap<>();
        var mentors = mentorService.getAllMentors();
        if (mentors.isEmpty()) {
            response.put("message", "No mentors found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        response.put("status", HttpStatus.OK);
        response.put("size", mentors.size());
        response.put("mentors", mentors);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Get request to fetch a mentor by id
    // /mentors/10
    @GetMapping("/mentors/{id}")
    public ResponseEntity<Map<Object, Object>> getMentorById(@PathVariable int id) {
        Mentor mentor = null;
        try {
            mentor = mentorService.getMentorById(id).orElseThrow(
                    () -> new MentorNotFoundException("Mentor not found with id: " + id));
        } catch (MentorNotFoundException e) {
            log.error(e.getMessage());
            response.put("message", e.getMessage());
            response.put("status", HttpStatus.NOT_FOUND);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        var mentorDto = modelMapper.map(mentor, MentorDto.class);
        response.put("status", HttpStatus.OK);
        response.put("response", mentorDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    // Delete request to delete a mentor by id
    // /mentors/10
    @DeleteMapping("/mentors/{id}")
    public ResponseEntity<Map<String, String>> deleteMentorById(@PathVariable int id) {
        mentorService.delete(mentorService.getMentorById(id).orElseThrow());
        Map<String, String> response = Map.of("message", "Mentor deleted successfully", "status",
                HttpStatus.OK.toString());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/mentors/find/{email}")
    public ResponseEntity<MentorDto> getMentorByEmail(@PathVariable String email) {
        var mentorDto = modelMapper.map(
                mentorService.findByEmail(email).orElseThrow(
                        () -> new NoSuchMentorException("Mentor not foudn with email " + email)),
                MentorDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(mentorDto);
    }

    @GetMapping("/mentors/find/{startDate}/{endDate}")
    public ResponseEntity<Map<Object, Object>> getMentorsByJoinDateBetween(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate endDate) {
        response = new HashMap<>();
        var mentors = mentorService.findByJoinDateBetween(startDate, endDate);
        if (mentors.isEmpty()) {
            response.put("message", "No mentors found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
        response.put("status", HttpStatus.OK);
        response.put("size", mentors.size());
        response.put("mentors", mentors);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

   
}
