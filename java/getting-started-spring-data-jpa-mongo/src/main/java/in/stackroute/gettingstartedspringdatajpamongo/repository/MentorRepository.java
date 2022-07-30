package in.stackroute.gettingstartedspringdatajpamongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import in.stackroute.gettingstartedspringdatajpamongo.domain.Mentor;

public interface MentorRepository extends MongoRepository<Mentor, String>{

}
