package com.example.college.student.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.college.student.model.StudentEntity;



@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Integer > {
	
	@Query("select s from StudentEntity s where s.studentName = :name")
	public List<StudentEntity> getStudentsByName(@Param("name") String name) ;
	
}
