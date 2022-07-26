package in.stackroute.gettingstartedspringdatajpa.controllers;

import java.util.List;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import in.stackroute.gettingstartedspringdatajpa.domain.Address;
import in.stackroute.gettingstartedspringdatajpa.domain.Mentor;
import in.stackroute.gettingstartedspringdatajpa.dto.MentorDto;
import in.stackroute.gettingstartedspringdatajpa.service.MentorService;

@RestController
public class MentorController {
    
    private MentorService mentorService;

    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    // Post request to create a new mentor
    @PostMapping("/mentors")
    public Mentor createMentor(@RequestBody @Valid MentorDto mentorDto) {
        Mentor mentor = getMentorInstance(mentorDto);
        return mentorService.create(mentor);
    }

    // Get request to fetch all mentors
    @GetMapping("/mentors")
    public List<Mentor> getAllMentors() {
        return mentorService.getAllMentors();
    }

    // Get request to fetch a mentor by id
    // /mentors/10
    @GetMapping("/mentors/{id}")
    public Mentor getMentorById(@PathVariable int id) {
        return mentorService.getMentorById(id).orElseThrow();
    }

    private Mentor getMentorInstance(MentorDto mentorDto){
        Mentor mentor = new Mentor();
        Address address = new Address();

        mentor.setName(mentorDto.getName());
        mentor.setEmail(mentorDto.getEmail());
        mentor.setTechnologies(mentorDto.getTechnologies());

        address.setCity(mentorDto.getAddress().getCity());
        address.setCountry(mentorDto.getAddress().getCountry());
        address.setState(mentorDto.getAddress().getState());
        address.setPinCode(mentorDto.getAddress().getPinCode());

        mentor.setAddress(address);
        return mentor;
    }

}
