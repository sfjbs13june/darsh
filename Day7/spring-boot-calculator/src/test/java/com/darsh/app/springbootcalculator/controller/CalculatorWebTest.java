package com.darsh.app.springbootcalculator.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(SpringRunner.class)
@WebMvcTest({Calculator.class})
@ActiveProfiles(value="test")
public class CalculatorWebTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${calculator.add.url}")
    String addurl;
    @Value("${calculator.sub.url}")
    String suburl;
    @Value("${calculator.mul.url}")
    String mulurl;
    @Value("${calculator.div.url}")
    String divurl;
    @Value("${calculator.addstr.url}")
    String addStrurl;

    @Test
    public void testCalculatorAdd() throws Exception{
        ResultActions responseEntity = mockMvc.perform(get(addurl).param("a","5").param("b","5"));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("10.0",result);
    }
    @Test
    public void testCalculatorSub() throws Exception{
        ResultActions responseEntity = mockMvc.perform(get(suburl).param("a","5").param("b","5"));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("0.0",result);
    }
    @Test
    public void testCalculatorMu() throws Exception{
        ResultActions responseEntity = mockMvc.perform(get(mulurl).param("a","5").param("b","5"));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("25.0",result);
    }
    @Test
    public void testCalculatorDiv() throws Exception{
        ResultActions responseEntity = mockMvc.perform(get(divurl).param("a","5").param("b","5"));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("1.0",result);
    }
    @Test
    public void testCalculatorAddString() throws Exception{
        ResultActions responseEntity = mockMvc.perform(get(addStrurl).param("a","str1").param("b","str2"));
        responseEntity.andExpect(status().isOk());
        String result = responseEntity.andReturn().getResponse().getContentAsString();
        assertEquals("str1str2",result);
    }
}
