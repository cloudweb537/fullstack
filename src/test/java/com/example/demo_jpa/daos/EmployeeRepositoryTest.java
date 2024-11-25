package com.example.demo_jpa.daos;
import com.example.demo_jpa.models.Employee;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class EmployeeRepositoryTest {


    @Autowired
    EmployeeRepository employeeRepository;

    List<Employee> employee;


    @BeforeEach
    void setUp() {
       employee= employeeRepository.findByName("mahesh");
    }

    @AfterEach
    void tearDown() {

    }

   //success
    @Test
    public void testFindByName_Found(){
        List<Employee> employeeList=employeeRepository.findByName("mahesh");
        System.out.println("Found");
        assertThat(employeeList.get(0).getId()).isEqualTo(employee.get(0).getId()
                );
        System.out.println();
    }

    //Failure
    @Test
    public void testFindByName_NotFound(){
        List<Employee> employeeList=employeeRepository.findByName("for");
        System.out.println("NotFound");
        assertThat(employeeList.isEmpty()).isTrue();
    }
}
