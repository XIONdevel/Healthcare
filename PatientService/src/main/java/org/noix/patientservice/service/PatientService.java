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

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final HealthRecordRepository recordRepository;
    private static final Logger logger = LoggerFactory.getLogger(PatientService.class);

    public Patient getPatientByPhone(String phone) {
        if (!isStringsValid(phone)) {
            Optional<Patient> optionalPatient = patientRepository.findByPhone(phone);
            if (optionalPatient.isEmpty()) {
                String message = String.format("Patient with phone number: %s not found", phone);
                logger.warn(message);
                throw new DataNotFoundException(message);
            }
            return optionalPatient.get();
        } else {
            logger.warn("Given phone is not valid: {}", phone);
            throw new DataNotValidException("Given phone is not valid: " + phone);
        }
    }

    public Patient getPatientByEmail(String email) {
        if (!isStringsValid(email)) {
            Optional<Patient> optionalPatient = patientRepository.findByEmail(email);
            if (optionalPatient.isEmpty()) {
                String message = String.format("Patient with email: %s not found", email);
                logger.warn(message);
                throw new DataNotFoundException(message);
            }
            return optionalPatient.get();
        } else {
            logger.warn("Given email is not valid: {}", email);
            throw new DataNotValidException("Given email is not valid: " + email);
        }

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
