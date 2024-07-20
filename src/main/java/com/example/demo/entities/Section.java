package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SECTIONS database table.
 * 
 */
@Entity
@Table(name="SECTIONS")
@NamedQuery(name="Section.findAll", query="SELECT s FROM Section s")
public class Section implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SEC_ID")
	private String secId;

	private String batch;

	private String dept;

	private String semester;

//	//bi-directional many-to-one association to Mark
//	@OneToMany(mappedBy="section")
//	private List<Mark> marks;

	//bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name="COURSE1")
	private Cours cours1;

	//bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name="COURSE2")
	private Cours cours2;

	//bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name="COURSE3")
	private Cours cours3;

	//bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name="COURSE4")
	private Cours cours4;

	//bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name="COURSE5")
	private Cours cours5;

	//bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name="COURSE6")
	private Cours cours6;

	//bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name="COURSE7")
	private Cours cours7;

//	//bi-directional many-to-one association to StudentSection
//	@OneToMany(mappedBy="section1")
//	private List<StudentSection> studentSections1;
//
//	//bi-directional many-to-one association to StudentSection
//	@OneToMany(mappedBy="section2")
//	private List<StudentSection> studentSections2;
//
//	//bi-directional many-to-one association to StudentSection
//	@OneToMany(mappedBy="section3")
//	private List<StudentSection> studentSections3;
//
//	//bi-directional many-to-one association to StudentSection
//	@OneToMany(mappedBy="section4")
//	private List<StudentSection> studentSections4;
//
//	//bi-directional many-to-one association to StudentSection
//	@OneToMany(mappedBy="section5")
//	private List<StudentSection> studentSections5;
//
//	//bi-directional many-to-one association to StudentSection
//	@OneToMany(mappedBy="section6")
//	private List<StudentSection> studentSections6;
//
//	//bi-directional many-to-one association to StudentSection
//	@OneToMany(mappedBy="section7")
//	private List<StudentSection> studentSections7;
//
//	//bi-directional many-to-one association to StudentSection
//	@OneToMany(mappedBy="section8")
//	private List<StudentSection> studentSections8;

//	//bi-directional many-to-one association to Teacher
//	@OneToMany(mappedBy="section")
//	private List<Teacher> teachers;

	public Section() {
	}

	public String getSecId() {
		return this.secId;
	}

	public void setSecId(String secId) {
		this.secId = secId;
	}

	public String getBatch() {
		return this.batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getDept() {
		return this.dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getSemester() {
		return this.semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

//	public List<Mark> getMarks() {
//		return this.marks;
//	}
//
//	public void setMarks(List<Mark> marks) {
//		this.marks = marks;
//	}
//
//	public Mark addMark(Mark mark) {
//		getMarks().add(mark);
//		mark.setSection(this);
//
//		return mark;
//	}
//
//	public Mark removeMark(Mark mark) {
//		getMarks().remove(mark);
//		mark.setSection(null);
//
//		return mark;
//	}

	public Cours getCours1() {
		return this.cours1;
	}

	public void setCours1(Cours cours1) {
		this.cours1 = cours1;
	}

	public Cours getCours2() {
		return this.cours2;
	}

	public void setCours2(Cours cours2) {
		this.cours2 = cours2;
	}

	public Cours getCours3() {
		return this.cours3;
	}

	public void setCours3(Cours cours3) {
		this.cours3 = cours3;
	}

	public Cours getCours4() {
		return this.cours4;
	}

	public void setCours4(Cours cours4) {
		this.cours4 = cours4;
	}

	public Cours getCours5() {
		return this.cours5;
	}

	public void setCours5(Cours cours5) {
		this.cours5 = cours5;
	}

	public Cours getCours6() {
		return this.cours6;
	}

	public void setCours6(Cours cours6) {
		this.cours6 = cours6;
	}

	public Cours getCours7() {
		return this.cours7;
	}

	public void setCours7(Cours cours7) {
		this.cours7 = cours7;
	}

//	public List<StudentSection> getStudentSections1() {
//		return this.studentSections1;
//	}
//
//	public void setStudentSections1(List<StudentSection> studentSections1) {
//		this.studentSections1 = studentSections1;
//	}
//
//	public StudentSection addStudentSections1(StudentSection studentSections1) {
//		getStudentSections1().add(studentSections1);
//		studentSections1.setSection1(this);
//
//		return studentSections1;
//	}
//
//	public StudentSection removeStudentSections1(StudentSection studentSections1) {
//		getStudentSections1().remove(studentSections1);
//		studentSections1.setSection1(null);
//
//		return studentSections1;
//	}
//
//	public List<StudentSection> getStudentSections2() {
//		return this.studentSections2;
//	}
//
//	public void setStudentSections2(List<StudentSection> studentSections2) {
//		this.studentSections2 = studentSections2;
//	}
//
//	public StudentSection addStudentSections2(StudentSection studentSections2) {
//		getStudentSections2().add(studentSections2);
//		studentSections2.setSection2(this);
//
//		return studentSections2;
//	}
//
//	public StudentSection removeStudentSections2(StudentSection studentSections2) {
//		getStudentSections2().remove(studentSections2);
//		studentSections2.setSection2(null);
//
//		return studentSections2;
//	}
//
//	public List<StudentSection> getStudentSections3() {
//		return this.studentSections3;
//	}
//
//	public void setStudentSections3(List<StudentSection> studentSections3) {
//		this.studentSections3 = studentSections3;
//	}
//
//	public StudentSection addStudentSections3(StudentSection studentSections3) {
//		getStudentSections3().add(studentSections3);
//		studentSections3.setSection3(this);
//
//		return studentSections3;
//	}
//
//	public StudentSection removeStudentSections3(StudentSection studentSections3) {
//		getStudentSections3().remove(studentSections3);
//		studentSections3.setSection3(null);
//
//		return studentSections3;
//	}
//
//	public List<StudentSection> getStudentSections4() {
//		return this.studentSections4;
//	}
//
//	public void setStudentSections4(List<StudentSection> studentSections4) {
//		this.studentSections4 = studentSections4;
//	}
//
//	public StudentSection addStudentSections4(StudentSection studentSections4) {
//		getStudentSections4().add(studentSections4);
//		studentSections4.setSection4(this);
//
//		return studentSections4;
//	}
//
//	public StudentSection removeStudentSections4(StudentSection studentSections4) {
//		getStudentSections4().remove(studentSections4);
//		studentSections4.setSection4(null);
//
//		return studentSections4;
//	}
//
//	public List<StudentSection> getStudentSections5() {
//		return this.studentSections5;
//	}
//
//	public void setStudentSections5(List<StudentSection> studentSections5) {
//		this.studentSections5 = studentSections5;
//	}
//
//	public StudentSection addStudentSections5(StudentSection studentSections5) {
//		getStudentSections5().add(studentSections5);
//		studentSections5.setSection5(this);
//
//		return studentSections5;
//	}
//
//	public StudentSection removeStudentSections5(StudentSection studentSections5) {
//		getStudentSections5().remove(studentSections5);
//		studentSections5.setSection5(null);
//
//		return studentSections5;
//	}
//
//	public List<StudentSection> getStudentSections6() {
//		return this.studentSections6;
//	}
//
//	public void setStudentSections6(List<StudentSection> studentSections6) {
//		this.studentSections6 = studentSections6;
//	}
//
//	public StudentSection addStudentSections6(StudentSection studentSections6) {
//		getStudentSections6().add(studentSections6);
//		studentSections6.setSection6(this);
//
//		return studentSections6;
//	}
//
//	public StudentSection removeStudentSections6(StudentSection studentSections6) {
//		getStudentSections6().remove(studentSections6);
//		studentSections6.setSection6(null);
//
//		return studentSections6;
//	}
//
//	public List<StudentSection> getStudentSections7() {
//		return this.studentSections7;
//	}
//
//	public void setStudentSections7(List<StudentSection> studentSections7) {
//		this.studentSections7 = studentSections7;
//	}
//
//	public StudentSection addStudentSections7(StudentSection studentSections7) {
//		getStudentSections7().add(studentSections7);
//		studentSections7.setSection7(this);
//
//		return studentSections7;
//	}
//
//	public StudentSection removeStudentSections7(StudentSection studentSections7) {
//		getStudentSections7().remove(studentSections7);
//		studentSections7.setSection7(null);
//
//		return studentSections7;
//	}
//
//	public List<StudentSection> getStudentSections8() {
//		return this.studentSections8;
//	}
//
//	public void setStudentSections8(List<StudentSection> studentSections8) {
//		this.studentSections8 = studentSections8;
//	}
//
//	public StudentSection addStudentSections8(StudentSection studentSections8) {
//		getStudentSections8().add(studentSections8);
//		studentSections8.setSection8(this);
//
//		return studentSections8;
//	}
//
//	public StudentSection removeStudentSections8(StudentSection studentSections8) {
//		getStudentSections8().remove(studentSections8);
//		studentSections8.setSection8(null);
//
//		return studentSections8;
//	}
//
//	public List<Teacher> getTeachers() {
//		return this.teachers;
//	}
//
//	public void setTeachers(List<Teacher> teachers) {
//		this.teachers = teachers;
//	}
//
//	public Teacher addTeacher(Teacher teacher) {
//		getTeachers().add(teacher);
//		teacher.setSection(this);
//
//		return teacher;
//	}
//
//	public Teacher removeTeacher(Teacher teacher) {
//		getTeachers().remove(teacher);
//		teacher.setSection(null);
//
//		return teacher;
//	}

}