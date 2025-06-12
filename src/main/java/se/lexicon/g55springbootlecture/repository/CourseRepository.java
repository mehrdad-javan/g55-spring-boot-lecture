package se.lexicon.g55springbootlecture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g55springbootlecture.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
