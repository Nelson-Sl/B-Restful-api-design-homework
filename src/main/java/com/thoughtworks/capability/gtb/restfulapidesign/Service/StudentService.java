package com.thoughtworks.capability.gtb.restfulapidesign.Service;

import com.thoughtworks.capability.gtb.restfulapidesign.Common.ExceptionMessage;
import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Exception.GenderNotFoundException;
import com.thoughtworks.capability.gtb.restfulapidesign.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudentList() {
        return this.studentRepository.getStudentList();
    }

    public List<Student> getStudentListByGender(String gender) {
        List<Student> studentListByGender = this.studentRepository.getStudentListByGender(gender);
        if(studentListByGender == null) {
            throw new GenderNotFoundException(ExceptionMessage.GENDER_NOT_FOUND_EXCEPTION_MESSAGE);
        }
        return studentListByGender;
    }

    public Student addNewStudent(Student student) {
        return this.studentRepository.addStudent(student);
    }

    public void deleteStudent(Integer id) {
        this.studentRepository.deleteStudent(id);
    }
}
