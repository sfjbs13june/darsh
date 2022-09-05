package com.darsh.mongo.contoller;

import com.darsh.mongo.model.Prescription;
import com.darsh.mongo.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PresciptionController {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @GetMapping("/viewprescription")
    public List<Prescription> getAllPrescriptions(String patientName){
        return prescriptionRepository.findByPatientName(patientName);
    }

    @PostMapping("/saveprescription")
    public Prescription savePrescription(@RequestBody Prescription prescription){
        return prescriptionRepository.save(prescription);
    }
}
