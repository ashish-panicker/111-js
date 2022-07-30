package in.stackroute.gettingstartedspringdatajpah2.service;

import java.time.LocalDate;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import in.stackroute.gettingstartedspringdatajpah2.domain.Address;
import in.stackroute.gettingstartedspringdatajpah2.domain.Mentor;
import in.stackroute.gettingstartedspringdatajpah2.repository.MentorRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MentorServiceTest {
    
    @Autowired
    private MentorRepository mentorRepository;

    @Autowired
    private MentorService mentorService;

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
    @DisplayName("Test cases to verify save method of mentor service")
    @Order(1)
    @Transactional
    /**
     * org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role:
     * in.stackroute.gettingstartedspringdatajpah2.domain.Mentor.technologies, could not initialize
     * proxy - no Session
     * 
     * https://stackoverflow.com/questions/46259878/org-hibernate-lazyinitializationexception-failed-to-lazily-initialize-a-collect
     */
    public void givenMetorDetails_whenSaved_thenReturnMentor() {

        Mentor saved1 = mentorService.create(mentor1);
        Mentor saved2 = mentorService.create(mentor2);
        assertThat(saved1).isNotNull();
        assertThat(saved2).isNotNull();
        assertThat(mentorService.getAllMentors().size()).isEqualTo(2);
    }
    
}
