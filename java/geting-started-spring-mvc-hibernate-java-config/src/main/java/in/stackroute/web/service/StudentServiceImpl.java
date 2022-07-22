package in.stackroute.web.service;

import org.springframework.stereotype.Service;
import in.stackroute.web.dao.StudentDao;
import in.stackroute.web.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Student getStudent(int id) {

        return studentDao.getStudent(id);
    }

    @Override
    public int addStudent(Student student) {

        return studentDao.addStudent(student);
    }

    @Override
    public Student updateStudent(Student student) {

        return studentDao.updateStudent(student);
    }

    @Override
    public void deleteStudent(int id) {

         studentDao.deleteStudent(id);
    }

}
