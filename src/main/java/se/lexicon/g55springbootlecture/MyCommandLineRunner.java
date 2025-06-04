package se.lexicon.g55springbootlecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.g55springbootlecture.entity.Student;
import se.lexicon.g55springbootlecture.repository.StudentRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    private StudentRepository studentRepository;

    @Autowired
    public MyCommandLineRunner(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("####### Application has started successfully! #######");
        Student student1 = new Student("Test", "Test", "test.test@test.se" );
        Student createdStudent = studentRepository.save(student1);
        System.out.println("createdStudent = " + createdStudent);
    }

}
