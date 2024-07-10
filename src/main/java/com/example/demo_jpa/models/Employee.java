package com.example.demo_jpa.models;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int age;
    private String address;

//    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", address='" + address + '\'' +
//                '}';
//    }
}
