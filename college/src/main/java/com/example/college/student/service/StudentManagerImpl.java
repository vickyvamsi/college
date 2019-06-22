package com.example.college.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.college.student.model.StudentEntity;
import com.example.college.student.model.StudentPojo;
import com.example.college.student.repo.StudentRepo;

@Service
public class StudentManagerImpl implements IStudentManager {
	
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	StudentManagerImpl studentManagerImpl;

	@Override
	public StudentPojo createStudent(StudentPojo student) {
		StudentEntity studentDao = new StudentEntity();
		studentDao.setStudentName(student.getStudentName());
		studentDao.setGrade(student.getGrade());
		studentDao.setMarks(student.getMarks());
		studentRepo.save(studentDao);
		student.setStudentId(studentDao.getStudentId());
		return student;
		
	}

	@Override
	public StudentEntity updateStudent(StudentPojo student) {
		// TODO Auto-generated method stub
		StudentEntity studentDao = studentManagerImpl.getStudent(student.getStudentId());
		studentDao.setStudentName(student.getStudentName());
		studentDao.setGrade(student.getGrade());
		studentDao.setMarks(student.getMarks());		
		return studentRepo.save(studentDao);
	}

	@Override
	public StudentEntity getStudent(int studentId) {
		// TODO Auto-generated method stub
		return studentRepo.findById(studentId).get();
	}

	@Override
	public String deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		StudentEntity studentDao =studentManagerImpl.getStudent(studentId);
		 studentRepo.delete(studentDao);
		 return "Student deleted successfully";
	}

	@Override
	public List<StudentEntity> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	public boolean checkStudent(int studentId) {
		// TODO Auto-generated method stub
		return studentRepo.existsById(studentId);
	}

	@Override
	public List<StudentEntity> getStudentsByName(String studentName) {
		// TODO Auto-generated method stub
		return studentRepo.getStudentsByName(studentName);
	}
	
	

}
