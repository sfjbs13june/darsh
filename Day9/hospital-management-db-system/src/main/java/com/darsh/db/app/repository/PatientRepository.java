package com.darsh.db.app.repository;

import com.darsh.db.app.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient,Integer> {
}
