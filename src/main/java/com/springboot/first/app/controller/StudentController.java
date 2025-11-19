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
		 String TOKEN_URL = "https://www.googleapis.com/oauth2/v4/token";
		  

	    // Not a best practice to store client id, secret and token in source
	    // must be stored in a file.
		 String oauthClientId = "21835-s6aksfsc8cc5eks1fgq063f0i8jr7coj.apps.googleusercontent.com";
		 String oauthSecret = "91a19ZsXUnzI3tytNPj";
		 String refreshToken = "1//0eJOp7AAGA4SNwF-L9IruQUPFrRQEDiMQA0ZdxhS4aIwK_Ddgv8CDuEXnz78tbc";
		 String accessToken = "ya29.a0AfH6SMAbPzlHI7Gvmq4Ttl1jjDQhLYBBe21PlJ76z1YHq4GtLl9rzPKfQn_DlN9Lub1RZUbZ0oeG_bHDKBfY950nHoH8r6T6U9T6t75Ifwv";
		 long tokenExpires = 14581664L;
		 String logoSrc="";
		return new Student("Sakil",accessToken);
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

























