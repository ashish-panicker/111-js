package in.stackroute.gettingstartedspringdatajpah2.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import in.stackroute.gettingstartedspringdatajpah2.domain.Mentor;
import in.stackroute.gettingstartedspringdatajpah2.repository.MentorRepository;

@Service
public class MentorServiceimpl implements MentorService {

    private MentorRepository mentorRepository;

    public MentorServiceimpl(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @Override
    public Mentor create(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    @Override
    public Mentor update(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    @Override
    public void delete(Mentor mentor) {
         mentorRepository.delete(mentor);
    }

    @Override
    public Optional<Mentor> getMentorById(int id) {
        return mentorRepository.findById(id);
    }

    @Override
    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }

    @Override
    public Optional<Mentor> findByEmail(String email) {
        return mentorRepository.findByEmail(email);
    }

    @Override
    public List<Mentor> findByJoinDateBetween(LocalDate startDate, LocalDate endDate) {
        return mentorRepository.findByJoinDateBetween(startDate, endDate);
    }
    
}
