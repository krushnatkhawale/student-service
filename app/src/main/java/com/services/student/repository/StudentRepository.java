package com.services.student.repository;

import com.services.student.exception.NotFoundException;
import com.services.student.model.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Repository
public class StudentRepository {

    private static final String NO_STUDENT_FOUND = "No student found";
    private static final String NO_STUDENTS_FOUND = "No STUDENTS found";

    private static final Map<String, Student> STUDENTS = new HashMap<>();

    public Student saveStudent(Student newStudent) {
        String id = UUID.randomUUID().toString();
        newStudent.setId(id);
        STUDENTS.put(id, newStudent);
        return newStudent;
    }

    public Student findStudent(String providedId) {
        return filterStudent(providedId);
    }

    public List<Student> findStudents() {
        return STUDENTS.values().stream().collect(Collectors.toList());
    }

    public void deleteStudent(String id) {
        STUDENTS.remove(id);
    }

    private Student filterStudent(String providedId) {
        if (isNull(STUDENTS.get(providedId))) {
            throw new NotFoundException(NO_STUDENT_FOUND);
        } else {
            return STUDENTS.get(providedId);
        }
    }
}