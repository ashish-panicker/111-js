package in.stackroute.gettingstartedspringdatajpah2.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import in.stackroute.gettingstartedspringdatajpah2.domain.Mentor;

public interface MentorRepository extends JpaRepository<Mentor, Integer> {

    Optional<Mentor> findByEmail(String email);

    List<Mentor> findByJoinDateBetween(LocalDate startDate, LocalDate endDate);

}
