package com.springbootlatest.service;

import com.springbootlatest.dto.Student;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService{

	private List<Student> students = new ArrayList<>();
	@Autowired
	ObservationRegistry observationRegistry;

	public Student addStudent(Student student){
		students.add(student);
		return Observation.createNotStarted("addStudent", observationRegistry).observe(()->student);
	}

	public List<Student> getStudents(){
		return Observation.createNotStarted("getStudents",observationRegistry).observe(()->students);
	}

	public Student getStudentById(int id){
		return Observation.createNotStarted("getStudentById", observationRegistry).observe(()->students.stream().filter(student -> student.id() == id).findAny()
				.orElseThrow(()->new RuntimeException("Student not found with id"+id)));
	}
}
