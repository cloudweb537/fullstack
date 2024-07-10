package com.example.demo_jpa.daos;

import com.example.demo_jpa.models.Employee;
import com.example.demo_jpa.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {


}
