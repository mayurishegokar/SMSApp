package edu.sms.app.serviceI;

import java.util.List;

import edu.sms.app.model.Student;

public interface StudentServiceI {

	public void saveStudent(Student s);
	public List<Student> getAllStudent();
	public List<Student> searchStudentByBatch(String batchNumber);
	public Student getStudentId(int studentId);
	public List<Student> removeStudent(int studentId);
	public List<Student> updateStudentfee(int studentId, float ammount);
	public List<Student> shiftStudentbatch(int studentId, String batchNumber);
	public List<Student> paging(int pageNo, int i);
	
	

}
