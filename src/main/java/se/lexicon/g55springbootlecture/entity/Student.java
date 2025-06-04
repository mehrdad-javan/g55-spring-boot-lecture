package se.lexicon.g55springbootlecture.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, length = 100)
    private String firstName;
    @Column(nullable = false, length = 100)
    private String lastName;
    @Column(nullable = false, length = 100, unique = true)
    private String email;

    private boolean status;
    private LocalDateTime createDate;


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


}
