package org.noix.patientservice.service;

import lombok.RequiredArgsConstructor;
import org.noix.patientservice.exception.DataNotFoundException;
import org.noix.patientservice.exception.DataNotValidException;
import org.noix.patientservice.model.Patient;
import org.noix.patientservice.repository.HealthRecordRepository;
import org.noix.patientservice.repository.PatientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final HealthRecordRepository recordRepository;
    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    public Patient getPatientByPhone(String phone) {
        if (!isStringsValid(phone)) {
            throw new DataNotValidException("Given phone is not valid: " + phone);
        }
        return patientRepository
                .findByPhone(phone)
                .orElseThrow(() -> new DataNotFoundException("User with given phone not found" + phone));
    }

    public Patient getPatientByEmail(String email) {
        if (!isStringsValid(email)) {
            throw new DataNotValidException("Given email is not valid: " + email);
        }
        return patientRepository
                .findByEmail(email)
                .orElseThrow(() -> new DataNotValidException("Patient with given email not found: " + email));
    }

    public List<Patient> getAllByFullName(String firstname, String lastname) {
        if (!isStringsValid(firstname, lastname)) {
            throw new DataNotValidException("Given name is not valid: " + firstname + " " + lastname);
        }
        List<Patient> patients = patientRepository.findAllByFirstnameAndLastname(firstname, lastname);
        if (patients.isEmpty()) {
            throw new DataNotFoundException("Patients with given name not found: " + firstname + " " + lastname);
        }
        return patients;
    }

    private boolean isStringsValid(String... strings) {
        for (String str : strings) {
            if (str == null || str.isBlank()) {
                return false;
            }
        }
        return true;
    }

}
