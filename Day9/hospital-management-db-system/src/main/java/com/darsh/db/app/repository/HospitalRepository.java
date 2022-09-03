package com.darsh.db.app.repository;

import com.darsh.db.app.model.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital,Integer> {
}
