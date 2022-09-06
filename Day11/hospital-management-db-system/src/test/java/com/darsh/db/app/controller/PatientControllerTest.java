package com.darsh.db.app.controller;

import com.darsh.db.app.model.Patient;
import com.darsh.db.app.repository.PatientRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest {
    @InjectMocks
    private PatientController patientController;

    @Mock
    private PatientRepository patientRepository;

    @Test
    public void savePatient() {
        Patient mockPatient = mock(Patient.class);
        Patient patient = new Patient();
        patient.setName("Darsh");
        patient.setId(1);
        patient.setHospitalName("WH");
        patient.setDisease("Asthma");
        when(patientRepository.save(any(Patient.class))).thenReturn(patient);
        Patient res = patientController.savePatient(mockPatient);
        assertEquals(res.getName(),patient.getName());
        assertEquals(res.getId(),patient.getId());
        assertEquals(res.getDisease(),patient.getDisease());
        assertEquals(res.getHospitalName(),patient.getHospitalName());
    }

    @Test
    public void getPatients() {
        Iterable<Patient> patientList = new ArrayList<>();
        Patient patient = new Patient();
        patient.setName("Darsh");
        patient.setId(1);
        patient.setHospitalName("WH");
        patient.setDisease("Asthma");
        ((ArrayList<Patient>) patientList).add(patient);
        when(patientRepository.findAll()).thenReturn(patientList);
        Iterable<Patient> res = patientController.getPatients();
        assertEquals(res.iterator().next().getName(),patientList.iterator().next().getName());
        assertEquals(res.iterator().next().getDisease(),patientList.iterator().next().getDisease());
        assertEquals(res.iterator().next().getId(),patientList.iterator().next().getId());
        assertEquals(res.iterator().next().getHospitalName(),patientList.iterator().next().getHospitalName());
    }

    @Test
    public void deletePatientById() {
        patientController.deletePatientById(1);
        verify(patientRepository,times(1)).deleteById(1);

    }

    @Test
    public void updatePatient() {
        Patient patient = new Patient();
        patient.setName("Darsh");
        patient.setId(1);
        patient.setHospitalName("WH");
        patient.setDisease("Asthma");
        when(patientRepository.findById(anyInt())).thenReturn(Optional.of(patient));
        Patient res = patientController.updatePatient(1,"Cancer");
        verify(patientRepository,times(1)).save(patient);
        assertEquals(res.getDisease(),"Cancer");
        assertEquals(res.getName(),patient.getName());
        assertEquals(res.getHospitalName(),patient.getHospitalName());
        assertEquals(res.getId(),patient.getId());
    }
}