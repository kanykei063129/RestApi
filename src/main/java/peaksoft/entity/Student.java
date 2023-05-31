package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {
    @Id
    @GeneratedValue(
            generator = "student_gen",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(
            name = "student_gen",
            sequenceName = "student_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private String email;
    private int age;
    private LocalDate createAdd;
    private boolean isBlocked;

    public Student(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}
