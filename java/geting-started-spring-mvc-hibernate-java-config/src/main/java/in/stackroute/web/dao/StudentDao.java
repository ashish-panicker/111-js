package in.stackroute.web.dao;

import in.stackroute.web.domain.Student;

public interface StudentDao {
    
    Student getStudent(int id);
    
    int addStudent(Student student);
    
    Student updateStudent(Student student);
    
    void deleteStudent(int id);
    
}
