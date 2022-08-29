package com.employee.app;

import org.springframework.stereotype.Component;

@Component
public class Employee {
    private String empId;
    private String empName;
    private String salary;
    private String dept;

    public Employee(String empId, String empName,String salary,String dept) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.dept = dept;
    }

    public Employee(){

    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}
