package se.lexicon.g55springbootlecture.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString(exclude = "email")

//@Data
// @Data is a Lombok annotation that generates boilerplate code such as getters, setters, equals, hashCode, and toString methods for the class.
@Entity
//@Table(name = "students")
public class Student {
    @Id
    @UuidGenerator // Generates a UUID for the ID field
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Setter(AccessLevel.NONE) // Prevents setting the ID manually
    private String id;
    @Column(nullable = false, length = 100)
    private String firstName;
    @Column(nullable = false, length = 100)
    private String lastName;
    @Column(nullable = false, length = 100, unique = true)
    private String email;

    private boolean status;
    private LocalDateTime createDate;

    // Cascade: is a feature in JPA that allows you to propagate operations performed on one entity to its related entities.
    // fetch: defines how the related entity is fetched from the database.
    // FetchType.EAGER: means that the related entity (Address) is fetched immediately when the Student is fetched.
    // FetchType.LAZY: means that the related entity is fetched only when it is accessed for the first time.
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id", unique = true)
    private Address address;

    @ManyToMany
    @JoinTable(
            name = "students_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> courses = new HashSet<>();

    @PrePersist
    public void onCreate() {
        this.status = true;
        this.createDate = LocalDateTime.now();
    }


    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // add helper methods to manipulate the courses set
    public void addCourse(Course course) {
        courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

}
