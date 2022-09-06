package com.darsh.db.app.controller;

import com.darsh.db.app.model.Hospital;
import com.darsh.db.app.repository.HospitalRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/hospital")
public class HospitalController {
    private HospitalRepository hospitalRepository;

    public HospitalController(HospitalRepository hospitalRepository){
        this.hospitalRepository = hospitalRepository;
    }

    @PostMapping("/save")
    @ResponseBody public Hospital saveHospital(@RequestBody Hospital hospital){
        return hospitalRepository.save(hospital);
        //return "saved";
    }

    @GetMapping("/get")
    @ResponseBody public Iterable<Hospital> getHospital(){
        return hospitalRepository.findAll();
    }

    @DeleteMapping("/delete")
    @ResponseBody public String deleteHospitalById(@RequestParam Integer id){
        hospitalRepository.deleteById(id);
        return "Deleted";
    }

    @PutMapping("/update")
    @ResponseBody public Hospital updateHospital(@RequestParam Integer id,@RequestParam String patientName){
        Hospital hospital = hospitalRepository.findById(id).get();
        hospital.setPatientName(patientName);
        hospitalRepository.save(hospital);
        return hospital;
    }
}
