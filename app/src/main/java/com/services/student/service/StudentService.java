package com.services.student.service;

import com.services.student.model.Student;
import com.services.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(@Autowired StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student student) {
        String id = UUID.randomUUID().toString();
        student.setId(id);
        return studentRepository.saveStudent(student);
    }

    public Student get(String id) {
        return studentRepository.findStudent(id);
    }

    public List<Student> getAll() {
        return studentRepository.findStudents();
    }

    public void delete(String id) {
        studentRepository.deleteStudent(id);
    }
}