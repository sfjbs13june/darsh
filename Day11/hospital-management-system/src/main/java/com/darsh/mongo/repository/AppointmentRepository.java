package com.darsh.mongo.repository;

import com.darsh.mongo.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {

    public List<Appointment> findByDoctorName(String doctorName);
    public List<Appointment> findByPatientName(String patientName);

    public Appointment save(Appointment appointment);
}
