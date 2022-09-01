package com.darsh.rest.patientapplication.controller;

import com.darsh.rest.patientapplication.model.Patient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({PatientController.class})
@ActiveProfiles(value = "test")
class PatientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Value("${patient.get.url}")
    String patientGetUrl;
    @Value("${patient.post.url}")
    String patientPostUrl;
    @Value("${patient.put.url}")
    String patientPutUrl;
    @Value("${patient.delete.url}")
    String patientDeleteUrl;

    @Test
    void getPatient() throws Exception {
        ResultActions resposneEntity = mockMvc.perform(get(patientGetUrl).param("patient_id","p2"));
        resposneEntity.andExpect(status().isOk());
        ObjectMapper objectMapper = new ObjectMapper();
        Patient result = objectMapper.readValue(resposneEntity.andReturn().getResponse().getContentAsString(),new TypeReference<Patient>(){});
        assertEquals("p1",result.getPatient_id());
        assertEquals("Darsh",result.getPatient_name());
        assertEquals("Asthma",result.getDisease());
        assertEquals("WH",result.getHospital_name());
    }
    @Test
    void deletePatient() throws Exception{
        ResultActions responseEntity  = mockMvc.perform(delete(patientDeleteUrl).param("patient_id","p1"));
        responseEntity.andExpect(status().isOk());
        String result=responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("Deleted", result);
    }
}