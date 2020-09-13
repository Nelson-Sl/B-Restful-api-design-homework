package com.thoughtworks.capability.gtb.restfulapidesign.Repository;

import com.thoughtworks.capability.gtb.restfulapidesign.Common.ExceptionMessage;
import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Exception.GenderNotFoundException;
import com.thoughtworks.capability.gtb.restfulapidesign.Exception.StudentNotFoundException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Student> getStudentListByGender(String gender) {
        try {
            return studentList.stream()
                    .filter(student -> student.getGender() == Gender.valueOf(gender.toUpperCase()))
                    .collect(Collectors.toList());
        }catch(IllegalArgumentException ex) {
            return null;
        }
    }

    public synchronized Student addStudent(Student student) {
        student.setId(studentList.size() + 1);
        studentList.add(student);
        return student;
    }

    public synchronized void deleteStudent(Integer id) {
        if(id > studentList.size()) {
            throw new StudentNotFoundException(ExceptionMessage.STUDENT_NOT_FOUND_EXCEPTION_MESSAGE);
        }
        for(Student stu: studentList) {
            if(stu.getId() == id) {
                studentList.remove(stu);
                break;
            }
        }
    }
}
