package com.thoughtworks.capability.gtb.restfulapidesign.Repository;

import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    private List<Student> studentList = new ArrayList<>();

    public StudentRepository() {
        Student newStudent = Student.builder().id(1).gender(Gender.MALE).name("Nelson")
                .note("GTB Term 2").build();
        studentList.add(newStudent);
    }

    public List<Student> getStudentList() {
        return studentList;
    }
}
