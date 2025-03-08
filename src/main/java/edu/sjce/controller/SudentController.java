package edu.sjce.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.sjce.model.StudentDetails;

import org.springframework.web.bind.annotation.PostMapping;


@RestController

public class SudentController {
	
	@GetMapping("/student/getProfile")
	public  StudentDetails getStudentDetails(@RequestParam String studentId){
		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setBranch("CSC");
		studentDetails.setDegree("BE");
		studentDetails.setName("Vishnu");
		studentDetails.setStudentId(studentId);
		studentDetails.setYear(2023);
		return studentDetails;
	}
	
	@PutMapping("/student/createProfile")
	public boolean createStudentDetails(@RequestBody StudentDetails studentDetails) {
		System.out.println("Student Id : " + studentDetails.getStudentId());
		System.out.println("Student name : " +studentDetails.getName());
		System.out.println("Student year : " +studentDetails.getYear());
		System.out.println("student branch : " + studentDetails.getBranch());
		System.out.println("Student Degree : " + studentDetails.getDegree());
		return true;
	}
	
	@PostMapping("/student/updateprofile")
	public boolean updateStudentDetails(@RequestBody StudentDetails studentDetails) {
		
		System.out.println("Student Id : " + studentDetails.getStudentId());
		System.out.println("Student name : " +studentDetails.getName());
		System.out.println("Student year : " +studentDetails.getYear());
		System.out.println("student branch : " + studentDetails.getBranch());
		System.out.println("Student Degree : " + studentDetails.getDegree());
		return true;
	}
	
	@DeleteMapping("/student/deleteprofile")
	public boolean deletestudentDetails(@RequestParam String studentId) {
		System.out.println("The Given StudentID was Deleted" + studentId);
		return true;
	}
	
	
	

}
