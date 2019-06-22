package com.example.college.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.college.student.model.StudentEntity;
import com.example.college.student.model.StudentPojo;
import com.example.college.student.service.IStudentManager;

@RestController
public class StudentController {
	@Autowired
	IStudentManager studentManager;
	
	@PostMapping("/student/create")
	public StudentPojo createStudent(@RequestBody StudentPojo student){
		return studentManager.createStudent(student);
	}
	
	@GetMapping("/getStudent/{studentId}")
	public StudentEntity getStudent(@PathVariable int studentId){
		return studentManager.getStudent(studentId);		
		
	}
	
	@GetMapping("/checkStudent/{studentId}")
	public boolean checkStudent(@PathVariable int studentId){
		
		return studentManager.checkStudent(studentId);		
		
	}
	
	@GetMapping("/getAllStudents")
	public List<StudentEntity> getStudents(){
		return studentManager.getAllStudents();
	}
	
	@PostMapping("/updateStudent")
	public StudentEntity updateStudent(@RequestBody StudentPojo student){
		return studentManager.updateStudent(student);
	}
	
	@GetMapping("/deleteStudent/{studentId}")
	public String deleteStudent(@PathVariable int studentId){
		
		return studentManager.deleteStudent(studentId);		
		
	}
	
	@GetMapping("/getStudentsByName")
	public List<StudentEntity> getStudentsByName(String StudentName){
		return studentManager.getStudentsByName(StudentName);
	}
}
