package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Attendance;
import com.example.demo.entities.Cours;
import com.example.demo.entities.Mark;
import com.example.demo.entities.Student;
import com.example.demo.entities.StudentSection;
import com.example.demo.entities.User;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@RequestMapping("/student/{id}")
	public Student getStudent(@PathVariable String id)
	{
		return studentService.getStudent(id);
	}
	
	@RequestMapping("/students")
	public Iterable<Student> getStudents()
	{
		return studentService.getStudents();
	}
	
	@RequestMapping(value="/student/{Id}/add",method=RequestMethod.POST)
	public void addStudent(@RequestBody Student student,@PathVariable String Id)
	{
		studentService.addStudent(student);
	}
	
	@RequestMapping("/student/{id}/marks")
	public Iterable<Mark> getMarks(@PathVariable String id)
	{
		return studentService.getMarks(id);
	}
	
	@RequestMapping("/student/{id}/attendance")
	public List<Attendance> getAttendance(@PathVariable String id)
	{
		return studentService.getAttendance(id);
	}
	
	@RequestMapping("/student/{id}/sections")
	public List<Cours> getSections(@PathVariable String id)
	{
		return studentService.getSections(id);
	}
	

}
