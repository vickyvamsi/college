package com.example.college.student.service;

import java.util.List;

import com.example.college.student.model.StudentEntity;
import com.example.college.student.model.StudentPojo;

public interface IStudentManager {
	
public StudentPojo createStudent(StudentPojo student);
public StudentEntity updateStudent(StudentPojo student);
public StudentEntity getStudent(int studentId); 
public boolean checkStudent(int studentId); 
public List<StudentEntity> getAllStudents();
public String deleteStudent(int studentId);
public List<StudentEntity> getStudentsByName(String studentName); 

}
