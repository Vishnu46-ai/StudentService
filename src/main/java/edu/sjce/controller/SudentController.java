package edu.sjce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.sjce.model.StudentDetails;
import edu.sjce.service.StudentService;

import org.springframework.web.bind.annotation.PostMapping;


@RestController

public class SudentController {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping("/student/{studentId}/getprofile")
	public  StudentDetails getStudentDetails(@PathVariable String studentId){
		StudentDetails studentDetails = studentService.getStudent(studentId);
		return studentDetails;
	}
	
	@PutMapping("/student/createprofile")
	public boolean createStudentDetails(@RequestBody StudentDetails studentDetails) {
		boolean createStatus = studentService.createStudent(studentDetails);
		return createStatus;
	}
	
	@PostMapping("/student/{studentId}/updateprofile")
	public boolean updateStudentDetails(@PathVariable String studentId, @RequestBody StudentDetails studentDetails) {
		boolean updateStatus = studentService.updateStudent(studentId, studentDetails);
		return updateStatus;
	}
	
	@DeleteMapping("/student/{studentId}/deleteprofile")
	public StudentDetails deletestudentDetails(@PathVariable String studentId) {
		StudentDetails studentDetails = studentService.removeStudent(studentId);
		return studentDetails;
	}

}
