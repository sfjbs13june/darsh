package com.darsh.mongo.repository;

import com.darsh.mongo.model.Prescription;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface PrescriptionRepository extends MongoRepository<Prescription,String> {

    public List<Prescription> findByPatientName(String patientName);

}
