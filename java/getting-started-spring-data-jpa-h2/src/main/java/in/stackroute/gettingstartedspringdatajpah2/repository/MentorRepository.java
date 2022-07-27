package in.stackroute.gettingstartedspringdatajpah2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.stackroute.gettingstartedspringdatajpah2.domain.Mentor;

public interface MentorRepository extends JpaRepository<Mentor, Integer> {

}
