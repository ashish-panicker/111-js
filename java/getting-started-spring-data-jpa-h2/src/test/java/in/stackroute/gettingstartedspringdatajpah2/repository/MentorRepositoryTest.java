package in.stackroute.gettingstartedspringdatajpah2.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import in.stackroute.gettingstartedspringdatajpah2.domain.Address;
import in.stackroute.gettingstartedspringdatajpah2.domain.Mentor;
import lombok.extern.slf4j.Slf4j;

@DataJpaTest
@Slf4j
public class MentorRepositoryTest {

    @Autowired
    private MentorRepository mentorRepository;

    private Mentor mentor1, mentor2;

    private Address address1, address2;


    @BeforeEach
    public void setUp() {

        address1 = new Address("Koramangala", "Karnataka", "India", "300300");

        address2 = new Address("Mumbai", "Maharshatra", "India", "400400");

        mentor1 = new Mentor(1, "Ashish S", "ashish.s@mail.com",
                List.of("Java", "Spring", "Hibernate"), LocalDate.now(), address1);

        mentor2 = new Mentor(2, "Rajesh R", "rajesh.r@gmail.com",
                List.of("Python", "Data Analysis", "Pyramid"), LocalDate.now(), address2);

    }

    @AfterEach
    public void tearDown() {
        mentor1 = null;
        mentor2 = null;
        address1 = null;
        address2 = null;
        mentorRepository.deleteAll();
    }

    @Test
    @DisplayName("Test cases to verify save method of mentor repository")
    @Order(1)
    public void givenMetorDetails_whenSaved_thenReturnMentor() {
        
        log.debug("saving mentor1");
        log.debug(mentor1.toString());   

        Mentor saved1 = mentorRepository.save(mentor1);
        Mentor saved2 = mentorRepository.save(mentor2);
        assertThat(saved1).isNotNull();
        assertThat(saved2).isNotNull();
        assertThat(mentorRepository.count()).isEqualTo(2);
    }

    @Test
    @DisplayName("Test cases to verify findByName method of mentor repository")
    @Order(2)
    public void givenMentorName_whenFindByEmail_thenReturnMentor() {
        mentorRepository.save(mentor1);
        Optional<Mentor> found = mentorRepository.findByEmail("ashish.s@mail.com");
        assertThat(found.isPresent()).isTrue();
        assertThat(found.get().getName()).isEqualTo("Ashish S");
    }

    @Test
    @DisplayName("Test cases to verify findByJoinDateBetween method of mentor repository")
    @Order(3)
    public void givenMentorJoinDate_whenFindByJoinDateBetween_thenReturnMentor() {
        mentorRepository.save(mentor1);
        mentorRepository.save(mentor2);
        List<Mentor> found = mentorRepository.findByJoinDateBetween(LocalDate.now().minusMonths(1), LocalDate.now());
        assertThat(found.size()).isEqualTo(2);
    }
}
