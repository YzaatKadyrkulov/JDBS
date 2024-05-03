package java13.services;

import java13.models.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    //create table
    void createTable();
    //save student
    String saveStudent(Student student);

    //find by id
    Optional<Student> findById(Long id);

    //find all
    List<Student> findAll();

    //delete by id
    boolean deleteById(Long id);

    //update
    boolean updateById(Long id, Student newStudent);
}
