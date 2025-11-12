package com.springboot.first.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.app.entity.Student;

@RestController
public class StudentController {

	//http://localhost:8080/student
	@GetMapping(path="/student",produces = "application/json")
	public Student getStudent() {
		return new Student("Sakil","Ahmmed");
	}
	
	//http://localhost:8080/students
	@GetMapping(path="/students",produces = "application/json")
	public List<Student> getStudents(){
		List<Student> students=new ArrayList();
		students.add(new Student("A","B"));
		students.add(new Student("A1","B1"));
		students.add(new Student("A2","B2"));
		return students;
		
	}
	
	//http://localhost:8080/student/sakil/ahmmed
	@GetMapping(path="/student/{firstName}/{lastName}",produces = "application/json")
	public Student studentPathVariable(@PathVariable("firstName") String fName, @PathVariable("lastName") String lName) {
		return new Student(fName,lName);
	}
	
	//http://localhost:8080/student/query?firstName=sakil&lastName=ahmmed
	@GetMapping(path="/student/query",produces = "application/json")
	public Student studentQueryParam(
			@RequestParam("firstName") String fName, 
			@RequestParam("lastName") String lName) 
	{
		return new Student(fName,lName);
	}
	
}

























