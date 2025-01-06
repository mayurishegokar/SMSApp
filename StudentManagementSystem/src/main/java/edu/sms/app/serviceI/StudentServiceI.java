package edu.sms.app.serviceI;

import java.util.List;

import edu.sms.app.model.Student;

public interface StudentServiceI {

	public void saveStudent(Student s);
	public List<Student> getAllStudent();
	

}
