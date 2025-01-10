package edu.sms.app.serviceImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sms.app.model.Student;
import edu.sms.app.repository.StudentRepository;
import edu.sms.app.serviceI.StudentServiceI;

@Service
public class StudentServiceImpl implements StudentServiceI {

	@Autowired
	StudentRepository sr;

	@Override
	public void saveStudent(Student s) {
		sr.save(s);
	}

	@Override
	public List<Student> getAllStudent() {
		
		return sr.findAll();
	}
	@Override
	public Student getStudentId(int id) {
		Optional<Student> op=sr.findById(id);
		return op.get();
	}
	
	@Override
	public List<Student> searchStudentByBatch(String batchNumber) {
		List<Student> batch=sr.findAllBybatchNumber(batchNumber);
		return batch;
	}

	@Override
	public List<Student> removeStudent(int studentId) {
		sr.deleteById(studentId);
		List<Student> list=sr.findAll();
		return list;
	}
	

	
}
