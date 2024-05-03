package java13.dao;

import java13.config.DatabaseConfig;
import java13.models.Student;

import java.sql.*;
import java.util.Optional;

public class StudentDaoImpl implements StudentDao, AutoCloseable {
    private final Connection connection = DatabaseConfig.getConnection();

    @Override
    public void createTable() {
        String sqlQuery = """
                create table if not exists students(
                id serial primary key,
                full_name varchar(50),
                email varchar(50),
                 date_of_birth date
                 )
                """;
        try (Statement statement = connection.createStatement()) {
            statement.execute(sqlQuery);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public boolean saveStudent(Student student) {
        String query = """
                insert into students(full_name, email, date_of_birth)
                values ( ?,?,?)""";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getFullName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setDate(3, Date.valueOf(student.getDateOfBirth()));
            preparedStatement.execute();
            preparedStatement.close();
            connection.prepareStatement(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Optional<Student> findById(Long id) {
        Student student = new Student();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                              select * from students where id = ?
                    """);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                throw new RuntimeException("Student with id: " + id + "not found!");

                student.setId(resultSet.getLong("id"));
                student.setFullName(resultSet.getString("full_name"));
                student.setEmail(resultSet.getString(3));
                student.setDateOfBirth(resultSet.getDate("date_of_birth").toLocalDate());

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return Optional.of();
    }

    @Override
    public Optional<Student> findAll() {
        Student student = new Student();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("""
                    select * from students = ?""");
            preparedStatement.setString(1, String.valueOf(student));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(student);
    }

    @Override
    public boolean deleteById(Long id) {
        return false;
    }

    @Override
    public boolean updateById(Long id, Student newStudent) {
        String query = """
                update students set full_name = ?,
                email = ?,
                date_of_birth = ?,
                where id = ?
                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newStudent.getFullName());
            preparedStatement.setString(2, newStudent.getEmail());
            preparedStatement.setDate(3, Date.valueOf(newStudent.getDateOfBirth()));
            preparedStatement.setLong(4, id);
            int rowsUpdate = preparedStatement.executeUpdate();
            return rowsUpdate > 0;
        } catch (SQLException e) {
            throw new RuntimeException("The given: " + id + " not found");
        }
    }

    @Override
    public void close() throws Exception {

    }
}
