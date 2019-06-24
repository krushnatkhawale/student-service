package com.services.student.model;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String id;
}