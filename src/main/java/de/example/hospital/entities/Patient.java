package de.example.hospital.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder

public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    @NotEmpty
    @Size(min = 3, max = 20)
    private String name;
    @NotEmpty
    @Size(min = 3, max = 20)
    private String vorname;
    @NotNull
    private Character geschlecht;
    private LocalDate geburtsdatum;
    private String adresse;
    private String telefon;
}
