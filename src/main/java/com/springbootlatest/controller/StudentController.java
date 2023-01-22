package com.springbootlatest.controller;

import com.springbootlatest.dto.Student;
import com.springbootlatest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentInfo")
public class StudentController{

	@Autowired
	StudentService studentService;

	@PostMapping
	Student addStudent(@RequestBody Student student){
		return studentService.addStudent(student);
	}

	@GetMapping
	List<Student> getStudents(){
		return studentService.getStudents();
	}

	@GetMapping("/{id}")
	Student getStudent(@PathVariable int id) {
		return studentService.getStudentById(id);
	}
}
