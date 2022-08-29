package com.employee.app;

import java.util.HashMap;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private HashMap<String,Employee> employeeHashMap = new HashMap<>();

    @GetMapping("/get/employee")
    public Employee getEmployee(@RequestParam String name){
        Employee employee = employeeHashMap.get(name);
        return employee;
    }
    @PostMapping("/save/employee")
    public void getEmployee(@RequestBody Employee employee){
        String employeeName = employee.getEmpName();
        employeeHashMap.put(employeeName,employee);
    }
    @PutMapping("/update/employee")
    public Employee updateEmployee(@RequestParam String salary,@RequestParam String name){
        Employee employee = employeeHashMap.get(name);
        employee.setSalary(salary);
        employeeHashMap.put(name,employee);
        return employee;
    }

    @DeleteMapping("/delete/employee")
    public void deleteEmployee(@RequestParam String name){
        employeeHashMap.remove(name);
    }
}
