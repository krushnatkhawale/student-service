package com.services.student.repository;

import com.services.student.exception.NotFoundException;
import com.services.student.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

@Repository
public class StudentRepository {

    private static final String NO_STUDENT_FOUND = "No student found";
    private static final String NO_STUDENTS_FOUND = "No STUDENTS found";

    private static final Map<String, Student> STUDENTS = new HashMap<>();

    public void saveStudent(Student newStudent) {
        STUDENTS.put(newStudent.getId(), newStudent);
    }

    public Student findStudent(String providedId) {
        return filterStudent(providedId);
    }

    public List<Student> findStudents() {
        if (STUDENTS.isEmpty()) {
            throw new NotFoundException(NO_STUDENTS_FOUND);
        } else {
            return new ArrayList<>(STUDENTS.values());
        }
    }

    private Student filterStudent(String providedId) {
        if (isNull(STUDENTS.get(providedId))) {
            throw new NotFoundException(NO_STUDENT_FOUND);
        } else {
            return STUDENTS.get(providedId);
        }
    }
}