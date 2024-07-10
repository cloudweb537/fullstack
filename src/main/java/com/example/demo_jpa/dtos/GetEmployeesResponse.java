package com.example.demo_jpa.dtos;


import com.example.demo_jpa.models.Employee;
import lombok.*;

import java.util.List;


@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetEmployeesResponse {

    List<Employee> employees;
}