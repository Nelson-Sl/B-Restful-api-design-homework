package com.thoughtworks.capability.gtb.restfulapidesign.Controller;

import com.thoughtworks.capability.gtb.restfulapidesign.Domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.Service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(@RequestParam(required = false) String gender) {
        if(gender == null) {
            return this.studentService.getStudentList();
        }
        return this.studentService.getStudentListByGender(gender);
    }

    @GetMapping("/{id}")
    public Student getAllStudentsById(@PathVariable int id) {
        return this.studentService.getStudentListById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student addNewStudent(@RequestBody Student student) {
        return this.studentService.addNewStudent(student);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(@PathVariable Integer id) {
        this.studentService.deleteStudent(id);
    }
}
