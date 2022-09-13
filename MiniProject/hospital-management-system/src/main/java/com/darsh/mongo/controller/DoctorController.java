package com.darsh.mongo.controller;

import com.darsh.mongo.model.Appointment;
import com.darsh.mongo.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @GetMapping("/doctorappointment")
    public List<Appointment> getAppointments(@RequestParam String doctorName){
        return appointmentRepository.findByDoctorName(doctorName);
    }

    @PostMapping("/save")
    public Appointment saveAppointment(@RequestBody Appointment appointment){
        return appointmentRepository.save(appointment);
    }
}
