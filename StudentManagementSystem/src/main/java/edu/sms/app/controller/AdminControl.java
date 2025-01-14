package edu.sms.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.sms.app.model.Student;
import edu.sms.app.serviceI.StudentServiceI;

@Controller
public class AdminControl {

	@Autowired
	StudentServiceI ssi;

	@RequestMapping("/")
	public String prelogin() {
		return "Login";
	}

	@RequestMapping("/login")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model m) {
		if (username.equals("admin") && password.equals("admin")) {
			List<Student> list = ssi.getAllStudent();
			m.addAttribute("data", list);
			return "adminscreen";
		} else {
			return "Login";
		}
	}

	@RequestMapping("/enroll_student")
	public String saveStudent(@ModelAttribute Student s, Model m) {
		ssi.saveStudent(s);
		List<Student> list = ssi.getAllStudent();
		m.addAttribute("data", list);
		return "adminscreen";
	}

	@RequestMapping("/search")
	public String serachBatch(@RequestParam("batchNumber") String batchNumber, Model m) {
		List<Student> result = ssi.searchStudentByBatch(batchNumber);
		if (result.size() > 0) {
			m.addAttribute("data", result);
			return "adminscreen";
		} else {
			List<Student> stu = ssi.getAllStudent();
			m.addAttribute("data", stu);
			m.addAttribute("message", "No records are available for the batch'" + batchNumber + "'...!");
			return "adminscreen";
		}
		
	}

	@RequestMapping("/remove")
	public String remove(@RequestParam("studentId") int studentId, Model m) {
		List<Student> list = ssi.removeStudent(studentId);
		m.addAttribute("data", list);
		return "adminscreen";

	}

	@RequestMapping("/fees")
	public String onFees(@RequestParam("studentId") int studentId, Model m) {
		Student s = ssi.getStudentId(studentId);
		m.addAttribute("st", s);
		return "fees";
	}

	@RequestMapping("/payfees")
	public String payFees(@RequestParam("studentId") int studentId, @RequestParam("ammount") float ammount, Model m) {

		List<Student> list=ssi.updateStudentfee(studentId,ammount);
		m.addAttribute("data", list);
		return "adminscreen";
	}
	
	@RequestMapping("/shiftbatch")
	public String shiftbatch(@RequestParam("studentId") int studentId,Model m)
	{
		Student s=ssi.getStudentId(studentId);
		m.addAttribute("st", s);
		return "shift";
	}
	
	@RequestMapping("/changebatch")
	public String changeBatch(@RequestParam("studentId") int studentId,@RequestParam("batchNumber") String batchNumber,Model m)
	{
		List<Student> list=ssi.shiftStudentbatch(studentId,batchNumber);
		m.addAttribute("data", list);
		return "adminscreen";
	}
	
	@RequestMapping("/paging")
	public String paging(@RequestParam("pageNo") int pageNo,Model m)
	{
		List<Student> list=ssi.paging(pageNo,2);
		m.addAttribute("data", list);
		return "adminscreen";
		
	}
}
