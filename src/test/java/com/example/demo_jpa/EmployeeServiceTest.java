package com.example.demo_jpa;

import com.example.demo_jpa.daos.EmployeeRepository;
import com.example.demo_jpa.models.Employee;
import com.example.demo_jpa.services.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

    @InjectMocks
    EmployeeService employeeService;

    @Mock
    EmployeeRepository employeeRepository;
    @Test
    public void testEmployeeCreation(){

        Employee employee=Employee.builder()
                .id(5)
                .name("mahesh")
                .address("adi")
                .age(24)
                .build();

        employeeService.create(employee);
        //Mockito.verify(employeeRepository,Mockito.timeout(1)).save((Mockito.any()));
        verify(employeeRepository,times(1)).save(any());

    }
    @Test
    public void testEmployeeGet(){
        when(employeeRepository.findAll()).thenReturn(Stream.of(new Employee(1,"Mahesh",22,"adi"),new Employee(2,"Babu",24,"adi")).collect(Collectors.toList()));
//        verify(employeeRepository,times(1)).save(any());
        assertEquals(2,
                employeeService.getEmployee().size());

    }
}
