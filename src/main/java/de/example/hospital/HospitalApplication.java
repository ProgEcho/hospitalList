package de.example.hospital;

import de.example.hospital.entities.Patient;
import de.example.hospital.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
public class HospitalApplication  implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        patientRepository.save(new Patient(null, "Balki", "Samir", 'M', LocalDate.of(1993, Month.APRIL, 3), "Cedar Lane 321", "O19992342"));

        patientRepository.save(new Patient(null, "Smith", "Emily", 'F', LocalDate.of(1985, Month.JULY, 15), "Maple Avenue 123", "O98765432"));

        patientRepository.save(new Patient(null, "Johnson", "Michael", 'M', LocalDate.of(1970, Month.MAY, 20), "Oak Street 456", "O76543210"));

        patientRepository.save(new Patient(null, "Garcia", "Sophia", 'F', LocalDate.of(1998, Month.JANUARY, 8), "Pine Road 789", "O54321098"));

        patientRepository.save(new Patient(null, "Wang", "Jason", 'M', LocalDate.of(1982, Month.DECEMBER, 12), "Cedar Lane 321", "O11223344"));

        patientRepository.save(new Patient(null, "Davis", "Olivia", 'F', LocalDate.of(1990, Month.SEPTEMBER, 25), "Spruce Boulevard 555", "O66778899"));

        patientRepository.save(new Patient(null, "Nguyen", "Andrew", 'M', LocalDate.of(1989, Month.MARCH, 18), "Willow Lane 876", "O22446688"));

        patientRepository.save(new Patient(null, "Kumar", "Priya", 'F', LocalDate.of(1987, Month.AUGUST, 5), "Elm Street 987", "O88997755"));



    }
}
