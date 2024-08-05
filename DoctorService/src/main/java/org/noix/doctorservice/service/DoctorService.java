package org.noix.doctorservice.service;

import lombok.RequiredArgsConstructor;
import org.noix.doctorservice.repository.DoctorRepository;
import org.noix.doctorservice.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final ScheduleRepository scheduleRepository;



}
