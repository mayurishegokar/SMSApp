package edu.sms.app.serviceImpl;

import java.util.List;

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
	
}
