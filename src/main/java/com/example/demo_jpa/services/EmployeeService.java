package com.example.demo_jpa.services;

import com.example.demo_jpa.daos.EmployeeRepository;
import com.example.demo_jpa.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Optional<Employee> getById(Integer employeeId){
        return employeeRepository
                .findById(employeeId);
    }

    public void create(Employee employee){
        employeeRepository.save(employee);
    }


    public List<Employee> getEmployee() {
        List<Employee> employees=employeeRepository.findAll();
        System.out.println("Test DB"+employees);
//        for(Employee e : employees){
//            System.out.println(e.toString());
//        }
        return employees;
    }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    public void deleteAll(){
        employeeRepository.deleteAll();
    }

    public void update(int id, Employee employee) {
        employee.setId(id);
        employeeRepository.save(employee);

    }


    public List<Employee> getByName(String name) {
        return employeeRepository.findByName(name);
    }
}
