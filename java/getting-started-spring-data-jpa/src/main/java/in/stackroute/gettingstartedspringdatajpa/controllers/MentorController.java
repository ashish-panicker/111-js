package in.stackroute.gettingstartedspringdatajpa.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import in.stackroute.gettingstartedspringdatajpa.domain.Mentor;
import in.stackroute.gettingstartedspringdatajpa.dto.MentorDto;
import in.stackroute.gettingstartedspringdatajpa.service.MentorService;

@RestController
public class MentorController {

    private MentorService mentorService;

    private ModelMapper modelMapper;

    public MentorController(MentorService mentorService, ModelMapper modelMapper) {
        this.mentorService = mentorService;
        this.modelMapper = modelMapper;
    }

    // Post request to create a new mentor
    // on successful creation of mentor, return the created mentor with status code 201
    @PostMapping("/mentors")
    public ResponseEntity<MentorDto> createMentor(@RequestBody @Valid MentorDto mentorDto) {
        Mentor mentor = modelMapper.map(mentorDto, Mentor.class);
        mentor = mentorService.create(mentor);
        mentorDto = modelMapper.map(mentor, MentorDto.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(mentorDto);
    }

    // Get request to fetch all mentors
    @GetMapping("/mentors")
    public ResponseEntity<Map<Object, Object>> getAllMentors() {
        Map<Object, Object> response = new HashMap<>();
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
    public ResponseEntity<MentorDto> getMentorById(@PathVariable int id) {
        var mentorDto = modelMapper.map(mentorService.getMentorById(id).orElseThrow(), MentorDto.class);
        return ResponseEntity.status(HttpStatus.OK).body(mentorDto);
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
}
