package com.darsh.db.app.controller;

import com.darsh.db.app.model.Patient;
import com.darsh.db.app.repository.PatientRepositroy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patient")
public class PatientController {
    private PatientRepositroy patientRepositroy;

    public PatientController(PatientRepositroy patientRepositroy){
        this.patientRepositroy = patientRepositroy;
    }

    @PostMapping("/save")
    public String savePatient(@RequestBody Patient patient){
        patientRepositroy.save(patient);
        return "saved";
    }
    @GetMapping("/get")
    public Iterable<Patient> getPatients(){
        return patientRepositroy.findAll();
    }
    @DeleteMapping("/delete")
    public String deletePatientById(@RequestParam Integer id){
        patientRepositroy.deleteById(id);
        return "Deleted";
    }
    @PutMapping("/update")
    public Patient updatePatient(@RequestParam Integer id,@RequestParam String disease){
        Patient patient = patientRepositroy.findById(id).get();
        patient.setDisease(disease);
        patientRepositroy.save(patient);
        return patient;
    }
}
