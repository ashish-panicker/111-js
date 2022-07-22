package in.stackroute.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import in.stackroute.web.domain.Student;
import in.stackroute.web.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ModelAndView createStudent() {

        Student student = new Student();
        student.setName("John");
        student.setEmail("john.doe");
        student.setPassword("john");
        student.setPhone("1234567890");

        int result = studentService.addStudent(student);
        System.out.println("\n\nRESULT " + result);

        System.out.println("\n\nSTUDENT\n" + studentService.getStudent(result));

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
