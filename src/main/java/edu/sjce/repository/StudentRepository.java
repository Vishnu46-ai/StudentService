package edu.sjce.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.sjce.dao.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

	Student findByStudentId(String studentId);
	long deleteByStudentId(String studentId);
}
