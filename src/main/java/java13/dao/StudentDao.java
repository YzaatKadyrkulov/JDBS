package java13.dao;

import java13.models.Student;

import java.util.Optional;

public interface StudentDao {
    //create students table
    void createTable();

    //save student
    boolean saveStudent(Student student);

    //find by id
    Optional<Student> findById(Long id);

    //find all
    Optional<Student> findAll();

    //delete by id
    boolean deleteById(Long id);

    //update
    boolean updateById(Long id, Student newStudent);
}
