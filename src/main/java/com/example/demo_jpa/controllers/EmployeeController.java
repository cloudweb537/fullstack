package com.example.demo_jpa.controllers;


import com.example.demo_jpa.dtos.CreateEmployeeRequest;
import com.example.demo_jpa.dtos.GetEmployeesResponse;
import com.example.demo_jpa.models.Employee;
import com.example.demo_jpa.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employee")
    public void createEmployee(@RequestBody @Valid CreateEmployeeRequest employeeRequest) {
        employeeService.create(employeeRequest.to());
    }

    @PutMapping("/employee/{id}")
    public void  updateEmployee(@PathVariable("id") Integer id, @RequestBody CreateEmployeeRequest employeeRequest) {
        employeeService.update(id, employeeRequest.to());
    }

    @GetMapping("/employees")
    public GetEmployeesResponse getEmployees() {
        return GetEmployeesResponse.builder().employees(employeeService.getEmployee()).build();
    }

    @GetMapping("/employee/{id}")
    public GetEmployeesResponse getEmployee(@PathVariable("id") Integer id) {
        Optional<Employee> employee = employeeService.getById(id);
        List<Employee> employeeList = employee.map(Arrays::asList).orElseGet(ArrayList::new);
        return GetEmployeesResponse.
                builder()
                .employees(employeeList)
                .build();
    }



    @DeleteMapping("/employee")
    public void deleteEmployee(@RequestParam("id") Integer id) {
        employeeService.delete(id);

    }
    @DeleteMapping("/employee/all")
    public void deleteAllEmployee(){
        employeeService.deleteAll();
    }


}
