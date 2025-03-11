package edu.sjce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjce.dao.Student;
import edu.sjce.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Student getStudent(String studentId) {
		return studentRepository.findByStudentId(studentId);
	}
}
