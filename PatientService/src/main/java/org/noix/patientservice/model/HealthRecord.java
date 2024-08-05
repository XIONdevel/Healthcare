package org.noix.patientservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "health_record")
public class HealthRecord {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Patient patient;

    private String name;
    private String description;

    private LocalDate start;
    private LocalDate finish;

    private String medications;
}
