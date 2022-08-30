package com.employee.app;

import java.util.HashMap;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private HashMap<String,Employee> employeeHashMap = new HashMap<>();

    @GetMapping("/get/employee")
    public Employee getEmployee(@RequestParam String name){
        Employee employee = employeeHashMap.get(name);
        if(employee == null){
            Employee test = new Employee("123","test","10000","DEV");
            return test;
        }else{
            return employee;
        }

    }
    @PostMapping("/save/employee")
    public Employee getEmployee(@RequestBody Employee employee){
        String employeeName = employee.getEmpName();
        employeeHashMap.put(employeeName,employee);
        return employee;
    }
    @PutMapping("/update/employee")
    public Employee updateEmployee(@RequestParam String salary,@RequestParam String name){
        Employee employee = employeeHashMap.get(name);
        if(employee == null){
            Employee test = new Employee("123",name,salary,"DEV");
            test.setSalary(salary);
            employeeHashMap.put(name,test);
            return test;
        }else{
            employee.setSalary(salary);
            employeeHashMap.put(name,employee);
            return employee;
        }

    }

    @DeleteMapping("/delete/employee")
    public String deleteEmployee(@RequestParam String name){
        employeeHashMap.remove(name);
        return "Deleted";
    }
}
