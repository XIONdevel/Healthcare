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
public class Patient {

    @Id
    @GeneratedValue
    private Long id;

    private String firstname;
    private String lastname;

    @Column(unique = true)
    private String phone;
    @Column(unique = true)
    private String email;

    private LocalDate dob;
    private String address;

    @Column(name = "doctor_id")
    private Long doctorId;

    @Column(unique = true, name = "security_number")
    private String securityNumber;







}
