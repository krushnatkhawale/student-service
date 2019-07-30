package com.services.student.controller;

import com.services.student.model.Student;
import com.services.student.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(@Autowired StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public ResponseEntity newStudent(@RequestBody Student student) {
        log.info("Save a student: {}", student.getId());
        studentService.save(student);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents() {
        log.info("Get all students");
        List<Student> allStudents = studentService.getAll();
        return ResponseEntity.ok(allStudents);
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable String id) {
        log.info("Get a student: {}", id);
        Student student = studentService.get(id);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id) {
        log.info("Delete a student: {}", id);
        studentService.delete(id);
        return ResponseEntity.ok().build();
    }

}