package in.stackroute;

import java.time.LocalDate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import in.stackroute.domain.Address;
import in.stackroute.domain.Author;
import in.stackroute.util.HibernateUtil;

/**
 * Main class
 */
public class App {
    public static void main(String[] args) {
        
        Author author = new Author();
        Address address = new Address();
        
        address.setCity("Pune");
        address.setState("Maharashtra");
        address.setCountry("India");
        address.setPincode("411028");

        author.setName("John");
        author.setEmail("john.doe@mail.com");
        author.setJoinDate(LocalDate.now());
        author.setAddres(address);

        System.out.println(author);

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(author);
        tx.commit();
        session.close();
        sessionFactory.close();
    }
}
