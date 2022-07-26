package in.stackroute.gettingstartedspringdatajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.stackroute.gettingstartedspringdatajpa.domain.Mentor;

public interface MentorRepository extends JpaRepository<Mentor, Integer> {

}
