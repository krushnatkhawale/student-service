package com.services.student.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Data
@NoArgsConstructor
@Table(name = "Students")
@Entity
public class Student {
    private String firstName;
    private String lastName;
    private String email;

    @Id
    private String id;
}