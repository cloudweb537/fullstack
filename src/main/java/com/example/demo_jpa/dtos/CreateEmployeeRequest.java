package com.example.demo_jpa.dtos;

import com.example.demo_jpa.models.Employee;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreateEmployeeRequest {
    @NotBlank
    private String name;

    @Min(30)
    @Max(50)
    private int age;
    private String address;
    public Employee to(){
        return Employee.builder()
                .name(this.name)
                .age(this.age)
                .address(this.address)
                .build();
    }

}
