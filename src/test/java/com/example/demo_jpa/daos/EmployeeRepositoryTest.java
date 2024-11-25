package com.example.demo_jpa.daos;
import com.example.demo_jpa.models.Employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
public class EmployeeRepositoryTest {


    @Autowired
    EmployeeRepository employeeRepository;

    Employee employee;


    @BeforeEach
    void setUp() {
        employee = new Employee(1,"mahesh",32,"AP");
        employeeRepository.save(employee);
    }

    @AfterEach
    void tearDown() {
        employeeRepository.deleteAll();
        System.out.println("00000");
    }

   //success
    @Test
    public void testFindByName_Found(){
        List<Employee> employeeList=employeeRepository.findByName("mahesh");
        System.out.println("Found");
        assertThat(employeeList.get(0).getId()).isEqualTo(employee.getId());
        System.out.println("2222");
    }

    //Failure
    @Test
    public void testFindByName_NotFound(){
        List<Employee> employeeList=employeeRepository.findByName("for");
        System.out.println("NotFound");
        assertThat(employeeList.isEmpty()).isTrue();
    }
}
