package com.luv2code.restapidemo.rest;

import com.luv2code.restapidemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    //Load the data only once
    @PostConstruct
    public void loadData() {
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima", "Patel"));
        theStudents.add(new Student("Mario", "Rosies"));
        theStudents.add(new Student("Mary", "Smith"));

    }

    //Define the GET method
    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }

    //Define endpoint or "/students/{studentID}" - return student at index
    @GetMapping("students/{studentId}")
    public Student getStudentByID(@PathVariable int studentId) {

        //Check the studentID again list size
        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("student id not found - " + studentId);
        }

        //Just index into the list
        return theStudents.get(studentId);
    }

}
