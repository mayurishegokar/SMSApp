package edu.sms.app.serviceImpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	
	@Override
	public Student getStudentId(int studentId) {
		Optional<Student> op=sr.findById(studentId);
		if(op.isPresent())
		{
			Student s=op.get();
			return s;
		}
		return null;
	}

	@Override
	public List<Student> updateStudentfee(int studentId, float ammount) {
		Optional<Student> op=sr.findById(studentId);
		
		if(op.isPresent())
		{
			Student uf=op.get();
			uf.setFeesPaid(uf.getFeesPaid()+ammount);
			sr.save(uf);
			
		}
		return sr.findAll();
	}

	@Override
	public List<Student> shiftStudentbatch(int studentId, String batchNumber) {
		Optional<Student> op=sr.findById(studentId);
		
		if(op.isPresent())
		{
			Student s=op.get();
			s.setBatchNumber(batchNumber);
			sr.save(s);
			return sr.findAll();
		}
		else {
			return null;	
		}
		
	}

	@Override
	public List<Student> paging(int pageNo, int i) {
		Pageable pageable=PageRequest.of(pageNo, i,Sort.by("studentFullName").ascending());
		List<Student> list=sr.findAll(pageable).getContent();
		return list;
	}

	

	
}
