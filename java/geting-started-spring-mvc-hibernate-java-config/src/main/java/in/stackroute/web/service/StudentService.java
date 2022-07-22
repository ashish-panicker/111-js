package in.stackroute.web.service;

import in.stackroute.web.domain.Student;

public interface StudentService {
    Student getStudent(int id);

    int addStudent(Student student);

    Student updateStudent(Student student);

    void deleteStudent(int id);
}
