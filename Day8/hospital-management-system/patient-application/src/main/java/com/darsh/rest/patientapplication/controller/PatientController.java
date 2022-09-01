package com.darsh.rest.patientapplication.controller;

import java.util.*;

import com.darsh.rest.patientapplication.model.Patient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {
    private HashMap<String, Patient> patienthmap = new HashMap<>();

    @GetMapping("/patient/get")
    public Patient getPatient(@RequestParam String patient_id){
        Patient patient = patienthmap.get(patient_id);
        if(patient == null){
            Patient test = new Patient("Darsh","p1","Asthma","WH");
            return test;
        }else{
            return patient;
        }
    }
    @DeleteMapping("/patient/delete")
    public String deletePatient(@RequestParam String patient_id){
        patienthmap.remove(patient_id);
        return "Deleted";

    }
}
