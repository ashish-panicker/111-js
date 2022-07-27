package in.stackroute.gettingstartedspringdatajpah2.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import in.stackroute.gettingstartedspringdatajpah2.domain.Mentor;

public interface MentorService {
    
    Mentor create(Mentor mentor);

    Mentor update(Mentor mentor);

    void delete(Mentor mentor);

    Optional<Mentor> getMentorById(int id);

    List<Mentor> getAllMentors();

    Optional<Mentor> findByEmail(String email);

    List<Mentor> findByJoinDateBetween(LocalDate startDate, LocalDate endDate);
}

/**
 * Optionals<Mentor> m = Optional.ofNullable(getMentorById(11));
 * m.ifPresent(mentor -> System.out.println(mentor.getName())).orElse(() -> System.out.println("No mentor found"));
 */
