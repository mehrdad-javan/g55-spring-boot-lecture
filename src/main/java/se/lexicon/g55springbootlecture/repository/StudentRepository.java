package se.lexicon.g55springbootlecture.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.g55springbootlecture.entity.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {
    // spring data jpa generates all basic CRUD operations for the Student entity
/*
    save(S entity); // insert into student values()
    saveAll(Iterable<S> entities);
    findById(ID id); // select * from student where id = ?
    existsById(ID id);
    findAll();
    findAllById(Iterable<ID> ids);
    long count();
    deleteById(ID id);
    delete(T entity);
    deleteAllById(Iterable<? extends ID> ids);
    deleteAll(Iterable<? extends T> entities);
    deleteAll();
 */

    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

    // select * from student where LOWER(first_name) like %?%
    List<Student> findByFirstNameIgnoreCaseContains(String firstName);

    @Query("select s from Student s where s.firstName = :firstName")
    List<Student> getStudentDataByFirstName(@Param("firstName") String firstName);


    // save method is used to insert a new student or update an existing one
    @Modifying // tells Spring Data JPA that this query will modify the database, and it is not a select query
    @Query("update Student s set s.status = :status where s.id= :id")
    int updateStudentStatusById(@Param("id") String id, @Param("status") boolean status);

    Optional<Student> findByEmail(String email);

    List<Student> findByFirstName(String firstName);
}
