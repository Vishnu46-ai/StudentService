package edu.sjce.service;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjce.dao.Student;
import edu.sjce.model.StudentDetails;
import edu.sjce.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public StudentDetails getStudent(String studentId) {
		StudentDetails studentDetails = new StudentDetails();
		Student student = studentRepository.findByStudentId(studentId);
		studentDetails.setStudentId(student.getStudentId());
		studentDetails.setName(student.getStudentName());
		studentDetails.setYear(student.getYear());
		studentDetails.setBranch(student.getDepartment());
		studentDetails.setDegree(student.getDegree());
		studentDetails.setBatch(student.getBatch());
		return studentDetails;
	}

	public boolean createStudent(StudentDetails studentDetails) {
		boolean createStudentStatus = false;
		try {
			Student student = new Student();
			student.setStudentId(studentDetails.getStudentId());
			student.setStudentName(studentDetails.getName());
			student.setDepartment(studentDetails.getBranch());
			student.setDegree(studentDetails.getDegree());
			student.setBatch(studentDetails.getBatch());
			student.setYear(studentDetails.getYear());
			studentRepository.insert(student);
			createStudentStatus = true;
		} catch ( Exception exception ) {
			System.out.println("Exception occurred during create student : " + exception);
		}
		return createStudentStatus;
	}

	public boolean updateStudent(String studentId, StudentDetails studentDetails) {
		Student student = null;
		boolean studentUpdateStatus = false;
		try {
			student = studentRepository.findByStudentId(studentId);
		} catch ( Exception exception ) {
			System.out.println("Exception during retrieval of student data for update : " + exception );
		}
		if ( student != null ) {
			try {
				student.setStudentName(studentDetails.getName());
				student.setDepartment(studentDetails.getBranch());
				student.setDegree(studentDetails.getDegree());
				student.setBatch(studentDetails.getBatch());
				student.setYear(studentDetails.getYear());
				studentRepository.save(student);
				studentUpdateStatus = true;
			} catch ( Exception exception ) {
				System.out.println("Exception during updation : " + exception );
			}
		}
		return studentUpdateStatus;
	}

	public StudentDetails removeStudent(String studentId) {
		StudentDetails studentDetails = new StudentDetails();
		try {
			Student student = studentRepository.deleteByStudentId(studentId);
			studentDetails.setStudentId(student.getStudentId());
			studentDetails.setName(student.getStudentName());
			studentDetails.setYear(student.getYear());
			studentDetails.setBranch(student.getDepartment());
			studentDetails.setDegree(student.getDegree());
			studentDetails.setBatch(student.getBatch());
		} catch ( Exception exception ) {
			System.out.println("Exception during deletion of student... : " + exception);
		}
		return studentDetails;
	}

}
