package de.example.hospital.repository;

import de.example.hospital.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    //Page<Patient> findByNameContainingIgnoreCase(String key, Pageable pageable);
    Page<Patient> findByNameContainingIgnoreCaseOrVornameContainingIgnoreCase(String nameKey, String vornameKey, Pageable pageable);

    @Query("select p from Patient p where p.name like :x OR p.vorname like :x")
    Page<Patient> search(@Param("x") String key, Pageable pageable);



}
