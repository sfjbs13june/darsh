package com.darsh.db.app.controller;

import com.darsh.db.app.model.Hospital;
import com.darsh.db.app.repository.HospitalRepository;
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
public class HospitalControllerTest {
    @InjectMocks
    private HospitalController hospitalController;
    @Mock
    private HospitalRepository hospitalRepository;
    @Test
    public void saveHospital() {
        Hospital mockHospital = mock(Hospital.class);
        Hospital hospital =new Hospital();
        hospital.setAddress("RingRoad");
        hospital.setId(1);
        hospital.setName("WH");
        hospital.setPatientName("Darsh");
        when(hospitalRepository.save(any(Hospital.class))).thenReturn(hospital);
        Hospital res = hospitalController.saveHospital(mockHospital);
        assertEquals(res.getAddress(),hospital.getAddress());
        assertEquals(res.getId(),hospital.getId());
        assertEquals(res.getName(),hospital.getName());
        assertEquals(res.getPatientName(),hospital.getPatientName());


    }

    @Test
    public void getHospital() {
        Iterable<Hospital> hospitalList = new ArrayList<>();
        Hospital hospital =new Hospital();
        hospital.setAddress("RingRoad");
        hospital.setId(1);
        hospital.setName("WH");
        hospital.setPatientName("Darsh");
        ((ArrayList<Hospital>) hospitalList).add(hospital);
        when(hospitalRepository.findAll()).thenReturn(hospitalList);
        Iterable<Hospital> res = hospitalController.getHospital();
        assertEquals(res.iterator().next().getName(),hospitalList.iterator().next().getName());
        assertEquals(res.iterator().next().getPatientName(),hospitalList.iterator().next().getPatientName());
        assertEquals(res.iterator().next().getAddress(),hospitalList.iterator().next().getAddress());
        assertEquals(res.iterator().next().getId(),hospitalList.iterator().next().getId());
    }

   @Test
    public void deleteHospitalById() {
       hospitalController.deleteHospitalById(1);
       verify(hospitalRepository,times(1)).deleteById(1);
    }

    @Test
    public void updateHospital() {
        Hospital hospital =new Hospital();
        hospital.setAddress("RingRoad");
        hospital.setId(1);
        hospital.setName("WH");
        hospital.setPatientName("Darsh");
        when(hospitalRepository.findById(anyInt())).thenReturn(Optional.of(hospital));
        Hospital res = hospitalController.updateHospital(1,"DBJ");
        verify(hospitalRepository,times(1)).save(hospital);
        assertEquals(res.getId(),hospital.getId());
        assertEquals(res.getPatientName(),"DBJ");
        assertEquals(res.getAddress(),hospital.getAddress());
        assertEquals(res.getName(),hospital.getName());
    }
}