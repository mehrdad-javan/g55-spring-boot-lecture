package se.lexicon.g55springbootlecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.lexicon.g55springbootlecture.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
