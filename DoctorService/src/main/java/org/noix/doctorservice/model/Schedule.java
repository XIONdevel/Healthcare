package org.noix.doctorservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "schedule_start")
    private Date scheduleStart;

    @Column(name = "schedule_end")
    private Date scheduleEnd;

    @ManyToOne(cascade = CascadeType.ALL)
    private Doctor doctor;


}
