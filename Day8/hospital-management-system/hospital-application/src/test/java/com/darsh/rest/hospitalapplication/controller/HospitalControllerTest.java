package com.darsh.rest.hospitalapplication.controller;

import com.darsh.rest.hospitalapplication.model.Hospital;
import com.darsh.rest.hospitalapplication.model.Patient;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({HospitalController.class})
@ActiveProfiles(value = "test")
class HospitalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${hospital.get.url}")
    String hospitalGetUrl;
    @Value("${hospital.post.url}")
    String hospitalPostUrl;
    @Value("${hospital.put.url}")
    String hospitalPutUrl;
    @Value("${hospital.delete.url}")
    String hospitalDeleteUrl;

    @Test
    void getHospital() throws Exception{
        ResultActions responseEntity = mockMvc.perform(get(hospitalGetUrl).param("hospital_id","h1"));
        responseEntity.andExpect(status().isOk());
        ObjectMapper objectMapper = new ObjectMapper();
        Patient patient = new Patient("Darsh","p1","Asthma","WH");
        List<Patient> patientList = new ArrayList<Patient>();
        patientList.add(patient);
        Hospital result = objectMapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(),new TypeReference<Hospital>(){});
        assertEquals("h1",result.getHospital_id());
        assertEquals("WH",result.getHospital_name());
        assertEquals("RingRoad",result.getAddress());
        //assertEquals(patientList,result.getPatients().get(0));
    }

    @Test
    void saveHospital() throws Exception{
        Patient patient = new Patient("Darsh","p1","Asthma","WH");
        List<Patient> patientList = new ArrayList<Patient>();
        patientList.add(patient);
        Hospital hospital = new Hospital("WHIH","h3","Gitanagar",patientList);

        ResultActions responseEntity = mockMvc.perform(post(hospitalPostUrl).contentType(MediaType.APPLICATION_JSON).content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        responseEntity.andExpect(status().isOk());
        ObjectMapper objectMapper = new ObjectMapper();
        Hospital result = objectMapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(),new TypeReference<Hospital>(){});
        assertEquals("h3",result.getHospital_id());
        assertEquals("WHIH",result.getHospital_name());
        assertEquals("Gitanagar",result.getAddress());
        //assertEquals(patientList,result.getPatients());
        //assertEquals(patientList,result.getPatients());
    }
    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            final String jsonContent = objectMapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void updateHospital() throws Exception{
        ResultActions responseEntity = mockMvc.perform(put(hospitalPutUrl).param("hospital_id","h4").param("address","MahadevNagar"));
        responseEntity.andExpect(status().isOk());
        ObjectMapper objectMapper = new ObjectMapper();
        Hospital result = objectMapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(), new TypeReference<Hospital>() {});
        assertEquals("h4",result.getHospital_id());
        assertEquals("WH",result.getHospital_name());
        assertEquals("MahadevNagar",result.getAddress());
        //assertEquals(patientList,result.getPatients());
    }

    @Test
    void deleteHospital() throws Exception{
        ResultActions responseEntity  = mockMvc.perform(delete(hospitalDeleteUrl).param("hospital_id","h1"));
        responseEntity.andExpect(status().isOk());
        String result=responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("Deleted", result);
    }
}