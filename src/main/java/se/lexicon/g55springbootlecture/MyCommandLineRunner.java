package se.lexicon.g55springbootlecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.g55springbootlecture.entity.Address;
import se.lexicon.g55springbootlecture.entity.Student;
import se.lexicon.g55springbootlecture.repository.AddressRepository;
import se.lexicon.g55springbootlecture.repository.StudentRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    private StudentRepository studentRepository;
    private AddressRepository addressRepository;

    @Autowired
    public MyCommandLineRunner(StudentRepository studentRepository, AddressRepository addressRepository) {
        this.studentRepository = studentRepository;
        this.addressRepository = addressRepository;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class, RuntimeException.class}) // rollback for any exception
    public void run(String... args) throws Exception {
/*
        Address address1 = new Address("Gothenburg", "Main Street", "41101");
        //address1 = addressRepository.save(address1); // id: 1

        //if (true) throw new RuntimeException("Oops! Something went wrong");
        // @Transactional will rollback the transaction if an exception occurs

        Student student1 = new Student("Person", "Person", "person@example.com");
        student1.setAddress(address1); // link address to student
        student1 = studentRepository.save(student1);

        System.out.println("Saved Student: " + student1);

        studentRepository.delete(student1);
        //addressRepository.delete(address1); // must delete address manually
*/
    }

}
