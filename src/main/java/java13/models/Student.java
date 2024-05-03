package java13.models;

import lombok.*;

import java.time.LocalDate;

/**
 * @author Yzaat Kadyrkulov
 */

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {
    private Long id;
    private String fullName;
    private String email;
    private LocalDate dateOfBirth;

    public Student(Long id, String fullName, String email, LocalDate dateOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
}