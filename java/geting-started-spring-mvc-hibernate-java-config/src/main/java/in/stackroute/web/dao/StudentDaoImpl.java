package in.stackroute.web.dao;

import javax.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import in.stackroute.web.domain.Student;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {

    private SessionFactory sessionFactory;

    public StudentDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Student getStudent(int id) {
        return sessionFactory.getCurrentSession().get(Student.class, id);
    }

    @Override
    public int addStudent(Student student) {
        return (int) sessionFactory.getCurrentSession().save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return (Student) sessionFactory.getCurrentSession().merge(student);
    }

    @Override
    public void deleteStudent(int id) {
         sessionFactory.getCurrentSession().delete(getStudent(id));
    }

}
