package java13.services;

import java13.dao.StudentDao;
import java13.dao.StudentDaoImpl;
import java13.models.Student;

import java.util.List;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void createTable() {
        studentDao.createTable();
    }

    @Override
    public String saveStudent(Student student) {
        return !(studentDao.saveStudent(student)) ?
                "Student successfully saved" : "Error: Failed to save student";
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentDao.findById(id).orElseThrow() ->
        new RuntimeException("Student with id: " + id + " not found");
    }

    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean updateById(Long id, Student newStudent) {
        boolean result = studentDao.updateById(id, newStudent);
        return result ? "Student with id: " + id + " successfully updated" :
                "Failed to update student with id: " + id;
    }
}
