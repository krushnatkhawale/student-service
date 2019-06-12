package com.services.student.service;

import com.services.student.model.Student;
import com.services.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(@Autowired StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void save(Student student) {
        studentRepository.saveStudent(student);
    }

    public Student get(String id) {
        return studentRepository.findStudent(id);
    }

    public List<Student> getAll() {
        return studentRepository.findStudents();
    }
}