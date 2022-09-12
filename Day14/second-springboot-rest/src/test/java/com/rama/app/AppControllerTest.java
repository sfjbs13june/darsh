package com.rama.app;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rama.app.controller.AppController;
import com.rama.app.data.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.Base64Utils;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({AppController.class})
@ActiveProfiles(value = "test")
public class AppControllerTest {
  @Autowired
  private MockMvc mockMvc;

  @Value("${employee.get.url}")
  String geturl;

  @Value("${employee.post.url}")
  String posturl;

  @Value("${employee.put.url}")
  String puturl;

  @Value("${employee.delete.url}")
  String deleteurl;
  @Value("${employee.path.url}")
  String pathurl;
  @Value("${employee.request.url}")
  String requesturl;
  @Value("${employee.requestparams.url}")
  String requestpurl;
  @Value("${employee.header.url}")
  String headersurl;

  @Value("${user.user1.username}")
  String username1;

  @Value("${user.user1.password}")
  String password1;

  @Value("${admin.user1.username}")
  String admin_name1;

  @Value("${user.user1.password}")
  String admin_password1;


  @Test
  public void testEmployeeGet() throws Exception {
    ResultActions responseEntity = processApiRequest(geturl, HttpMethod.GET, null,
      null, username1, password1);
    responseEntity.andExpect(status().isOk());
    ObjectMapper mapper = new ObjectMapper();
    String result = responseEntity.andReturn().getResponse().getContentAsString();
    assertEquals("get employee ", result);
  }

  @Test
  public void testEmployeePost() throws Exception {
    Employee employee = createEmployee("test", "dev");
    ResultActions responseEntity = processApiRequest(posturl, HttpMethod.POST, null, employee, admin_name1, admin_password1);
    responseEntity.andExpect(status().isOk());
    ObjectMapper mapper = new ObjectMapper();
    Employee result = mapper.readValue(responseEntity.andReturn().getResponse().getContentAsString(),
      new TypeReference<Employee>() {
      });

    assertEquals("test", result.getName());
    assertEquals("dev", result.getRole());

  }
  @Test
  public void testEmployeeDelete() throws Exception{
    Employee employee = createEmployee("test", "dev");
    ResultActions responseEntity = processApiRequest(deleteurl,HttpMethod.DELETE,employee.getName(),employee,admin_name1,admin_password1);
    responseEntity.andExpect(status().isOk());
    String res = responseEntity.andReturn().getResponse().getContentAsString();
    assertEquals(employee.getName(),res);
  }

  @Test
  public void testEmployeePut() throws Exception{
    Employee employee = createEmployee("test", "dev");
    ResultActions responseEntity = processApiRequest(puturl, HttpMethod.PUT,employee.getName(),employee,admin_name1,admin_password1);
    responseEntity.andExpect(status().isOk());
    String res = responseEntity.andReturn().getResponse().getContentAsString();
    String emp = employee.toString() + ":Updated with name:" + employee.getName();
    assertEquals(emp,res);
  }
  @Test
  public void testEmployeePath() throws Exception{
    Employee employee = createEmployee("test", "dev");
    ResultActions responseEntity = mockMvc.perform(get(pathurl,employee.getName()).param("name", employee.getName()).header(HttpHeaders.AUTHORIZATION,"Basic " + Base64Utils.encodeToString((admin_name1+":"+admin_password1).getBytes())));
    responseEntity.andExpect(status().isOk());
    String res = responseEntity.andReturn().getResponse().getContentAsString();
    assertEquals("Path Variable:"+employee.getName(),res);
  }
  @Test
  public void testEmployeeRequest() throws Exception{
    ResultActions responseEntity = mockMvc.perform(get(requesturl).header(HttpHeaders.AUTHORIZATION,"Basic " + Base64Utils.encodeToString((admin_name1+":"+admin_password1).getBytes())));
    responseEntity.andExpect(status().isOk());
    String res = responseEntity.andReturn().getResponse().getContentAsString();
    assertEquals("Request Param:rama",res);
  }
  @Test
  public void testEmployeeRequestParam() throws Exception{
    List<String> idList=new ArrayList<>();
    idList.add("DBJ");
    idList.add("TCS");
    ResultActions responseEntity=mockMvc.perform(get(requestpurl).param("id", String.valueOf(idList)).header(HttpHeaders.AUTHORIZATION,"Basic " + Base64Utils.encodeToString((admin_name1+":"+admin_password1).getBytes())));
    responseEntity.andExpect(status().isOk());
    String result=responseEntity.andReturn().getResponse().getContentAsString();
    assertEquals("Request Param:[[DBJ, TCS]]", result);
  }
  /*@Test
  public void testEmployeeHeaders() throws Exception{
    HttpHeaders header = new HttpHeaders();
    header.setExpires(ZonedDateTime.now()
            .plusDays(1));
    String response = "Valid Header";
    ResultActions responseEntity = mockMvc.perform(get(headersurl).headers(header).header(HttpHeaders.AUTHORIZATION,"Basic " + Base64Utils.encodeToString((admin_name1+":"+admin_password1).getBytes())));
    responseEntity.andExpect(status().isOk());
    System.out.println(responseEntity);
    //ResponseEntity<String> res = responseEntity.andReturn().getResponse();
  }*/


  private ResultActions processApiRequest(String api, HttpMethod methodType, String name, Employee employee, String username, String password) {
    ResultActions response = null;
    String secret = "Basic " + Base64Utils.encodeToString((username+":"+password).getBytes());//YWRtaW4xMjM6cGFzc3dvcmQ=
    try {
      switch (methodType) {
        case GET:
          response = mockMvc.perform(get(api).header(HttpHeaders.AUTHORIZATION, secret));
          break;
        case POST:
          response = mockMvc.perform(post(api).header(HttpHeaders.AUTHORIZATION, secret).contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(employee)).accept(MediaType.APPLICATION_JSON));
          break;
        case PUT:
          response = mockMvc.perform(put(api, name).header(HttpHeaders.AUTHORIZATION, secret).contentType(MediaType.APPLICATION_JSON)
            .content(asJsonString(employee)).accept(MediaType.APPLICATION_JSON));
          break;
        case DELETE:
          response = mockMvc.perform(delete(api, name).header(HttpHeaders.AUTHORIZATION, secret));
          break;
        default:
          fail("Method Not supported");
          break;
      }
    } catch (Exception e) {
      e.printStackTrace();
      fail();
    }
    return response;
  }

  private String asJsonString(final Object obj) {
    try {
      final ObjectMapper mapper = new ObjectMapper();
      final String jsonContent = mapper.writeValueAsString(obj);
      return jsonContent;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private static Employee createEmployee(String name, String role) {
    Employee empEmployee = new Employee(name, role);
    return empEmployee;
  }
}
