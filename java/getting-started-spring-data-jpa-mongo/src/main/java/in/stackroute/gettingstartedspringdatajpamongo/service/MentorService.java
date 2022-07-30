package in.stackroute.gettingstartedspringdatajpamongo.service;

import java.util.List;
import java.util.Optional;
import in.stackroute.gettingstartedspringdatajpamongo.domain.Mentor;

public interface MentorService {
    
    Mentor create(Mentor mentor);

    Mentor update(Mentor mentor);

    void delete(Mentor mentor);

    Optional<Mentor> getMentorById(String id);

    List<Mentor> getAllMentors();
}

/**
 * Optionals<Mentor> m = Optional.ofNullable(getMentorById(11));
 * m.ifPresent(mentor -> System.out.println(mentor.getName())).orElse(() -> System.out.println("No mentor found"));
 */
