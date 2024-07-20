package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Attendance;
import com.example.demo.entities.Cours;
import com.example.demo.entities.Mark;
import com.example.demo.entities.Section;
import com.example.demo.entities.Student;
import com.example.demo.entities.StudentSection;
import com.example.demo.entities.User;
import com.example.demo.repositories.AttendanceRepository;
import com.example.demo.repositories.MarkRepository;
import com.example.demo.repositories.StudentRepository;
import com.example.demo.repositories.StudentSectionRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MarkRepository markRepository;
	
	@Autowired
	AttendanceRepository attendanceRepository;
	
	@Autowired
	StudentSectionRepository studentSectionRepository;
	
	ArrayList<Cours> courses=new ArrayList<>();
	
	public Student getStudent(String sid)
	{
		return studentRepository.findOne(sid);
	}
	
	public Iterable<Student> getStudents()
	{
		return studentRepository.findAll();
	}
	
	public void addStudent(Student student)
	{
		studentRepository.save(student);
	}
	
	public List<Mark> getMarks(String uid)
	{
		User u=new User();
		u.setUserId(uid);
		List<Mark> marlist=new ArrayList<>();
		markRepository.findByUser(u).forEach(marlist::add);
		return marlist;
	}
	
	public List<Attendance> getAttendance(String uid)
	{
		User u=new User();
		u.setUserId(uid);
		List<Attendance> attlist= new ArrayList<>();
		attendanceRepository.findByUser(u).forEach(attlist::add);
		return attlist;
	}
	
	public List<Attendance> getAttendanceByCourse(String uid,Cours c)
	{
		User u=new User();
		u.setUserId(uid);
		List<Attendance> attlist= new ArrayList<>();
		attendanceRepository.findByUserAndCours(u,c).forEach(attlist::add);
		return attlist;
	}
	
	public List<Attendance> getAttendanceByCourseAndStatus(String uid,Cours c,String status)
	{
		User u=new User();
		u.setUserId(uid);
		List<Attendance> attlist= new ArrayList<>();
		attendanceRepository.findByUserAndCoursAndStatus(u,c,status).forEach(attlist::add);
		return attlist;
	}
	
	public Student getStudentByParent(User user)
	{
		return studentRepository.findByUser2(user);
	}

	public List<Cours> getSections(String sid)
	{
		StudentSection sec= studentSectionRepository.findOne(sid);
		courses.clear();
		if(sec.getSection1()!=null)
		{
			getCoursesFromSections(sec.getSection1());
		}
		if(sec.getSection2()!=null)
		{
			getCoursesFromSections(sec.getSection2());
		}
		if(sec.getSection3()!=null)
		{
			getCoursesFromSections(sec.getSection3());
		}
		if(sec.getSection4()!=null)
		{
			getCoursesFromSections(sec.getSection4());
		}
		if(sec.getSection5()!=null)
		{
			getCoursesFromSections(sec.getSection5());
		}
		if(sec.getSection6()!=null)
		{
			getCoursesFromSections(sec.getSection6());
		}
		if(sec.getSection7()!=null)
		{
			getCoursesFromSections(sec.getSection7());
		}
		if(sec.getSection8()!=null)
		{
			getCoursesFromSections(sec.getSection8());
		}
		return courses;
	}
	
	public void getCoursesFromSections(Section section)
	{
		courses.add(section.getCours1());
		courses.add(section.getCours2());
		courses.add(section.getCours3());
		courses.add(section.getCours4());
		courses.add(section.getCours5());
		courses.add(section.getCours6());
		courses.add(section.getCours7());
	}

}
