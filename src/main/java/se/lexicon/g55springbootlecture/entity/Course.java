package se.lexicon.g55springbootlecture.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 100)
    private String courseName;

    //@ManyToMany(mappedBy = "courses")
    //private Set<Student> students = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    public Course(String courseName) {
        this.courseName = courseName;
    }
}
