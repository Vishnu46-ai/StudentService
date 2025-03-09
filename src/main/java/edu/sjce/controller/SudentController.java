package edu.sjce.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.sjce.model.StudentDetails;

import org.springframework.web.bind.annotation.PostMapping;


@RestController

public class SudentController {
	
	@GetMapping("/student/{studentId}/getprofile")
	public  StudentDetails getStudentDetails(@PathVariable String studentId){
		StudentDetails studentDetails = new StudentDetails();
		studentDetails.setBranch("CSC");
		studentDetails.setDegree("BE");
		studentDetails.setName("Vishnu");
		studentDetails.setStudentId(studentId);
		studentDetails.setYear(2023);
		return studentDetails;
	}
	
	@PutMapping("/student/createprofile")
	public boolean createStudentDetails(@RequestBody StudentDetails studentDetails) {
		System.out.println("Student Id : " + studentDetails.getStudentId());
		System.out.println("Student name : " + studentDetails.getName());
		System.out.println("Student year : " + studentDetails.getYear());
		System.out.println("student branch : " + studentDetails.getBranch());
		System.out.println("Student Degree : " + studentDetails.getDegree());
		return true;
	}
	
	@PostMapping("/student/{studentId}/updateprofile")
	public boolean updateStudentDetails(@PathVariable String studentId, @RequestBody StudentDetails studentDetails) {
		
		System.out.println("Student Id : " + studentId);
		System.out.println("Student name : " + studentDetails.getName());
		System.out.println("Student year : " + studentDetails.getYear());
		System.out.println("student branch : " + studentDetails.getBranch());
		System.out.println("Student Degree : " + studentDetails.getDegree());
		return true;
	}
	
	@DeleteMapping("/student/{studentId}/deleteprofile")
	public boolean deletestudentDetails(@PathVariable String studentId) {
		System.out.println("The Given StudentID was Deleted" + studentId);
		return true;
	}
	
	
	

}
