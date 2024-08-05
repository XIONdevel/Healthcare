package org.noix.doctorservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Doctor {

    @Id
    @GeneratedValue
    private Long id;

    private String firstname;
    private String lastname;

    private LocalDate dob;

    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String email;

    private String position;
}
