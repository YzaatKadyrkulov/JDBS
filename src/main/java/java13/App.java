package java13;

import java13.models.Student;
import java13.services.StudentService;
import java13.services.StudentServiceImpl;

import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        StudentService studentService = new StudentServiceImpl();
        studentService.createTable();

//        studentService.saveStudent(new Student("Yzaat Kadyrkulov", "yzaat@gmail.com",
//                LocalDate.of());

        try {
            System.out.println(studentService.findById(3L));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        System.out.println(studentService.updateById(3L, student));
    }
}
