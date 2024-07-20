package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the USERS database table.
 * 
 */
@Entity
@Table(name="USERS")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="USER_ID")
	private String userId;

	private String column1;

	private String column2;

	private String emailid;

	private String gender;

	private String name;

	private String password;

	private BigDecimal sno;

	private String status;

//	//bi-directional many-to-one association to Attendance
//	@OneToMany(mappedBy="user")
//	private List<Attendance> attendances;

//	//bi-directional many-to-one association to GatepassTable
//	@OneToMany(mappedBy="user1")
//	private List<GatepassTable> gatepassTables1;
//
//	//bi-directional many-to-one association to GatepassTable
//	@OneToMany(mappedBy="user2")
//	private List<GatepassTable> gatepassTables2;
//
//	//bi-directional many-to-one association to GatepassTable
//	@OneToMany(mappedBy="user3")
//	private List<GatepassTable> gatepassTables3;

//	//bi-directional many-to-one association to Mark
//	@OneToMany(mappedBy="user")
//	private List<Mark> marks;

//	//bi-directional one-to-one association to Student
//	@OneToOne(mappedBy="user1")
//	private Student student;
//
//	//bi-directional many-to-one association to Student
//	@OneToMany(mappedBy="user2")
//	private List<Student> students;

//	//bi-directional one-to-one association to StudentSection
//	@OneToOne(mappedBy="user")
//	private StudentSection studentSection;

//	//bi-directional many-to-one association to Teacher
//	@OneToMany(mappedBy="user")
//	private List<Teacher> teachers;

	//bi-directional many-to-many association to Role
	@ManyToMany
	@JoinTable(
		name="USER_ROLES"
		, joinColumns={
			@JoinColumn(name="USER_ID")
			}
		, inverseJoinColumns={
			@JoinColumn(name="ROLE_ID")
			}
		)
	private List<Role> roles;

//	//bi-directional one-to-one association to Warden
//	@OneToOne(mappedBy="user")
//	private Warden warden;
	
//	//bi-directional many-to-one association to UserRole
//	@OneToMany(mappedBy="user")
//	private List<UserRole> userRoles;

	public User() {
	}
	
	public User(String username) {
		this.userId=username;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getColumn1() {
		return this.column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}

	public String getColumn2() {
		return this.column2;
	}

	public void setColumn2(String column2) {
		this.column2 = column2;
	}

	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getSno() {
		return this.sno;
	}

	public void setSno(BigDecimal sno) {
		this.sno = sno;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

//	public List<Attendance> getAttendances() {
//		return this.attendances;
//	}
//
//	public void setAttendances(List<Attendance> attendances) {
//		this.attendances = attendances;
//	}
//
//	public Attendance addAttendance(Attendance attendance) {
//		getAttendances().add(attendance);
//		attendance.setUser(this);
//
//		return attendance;
//	}
//
//	public Attendance removeAttendance(Attendance attendance) {
//		getAttendances().remove(attendance);
//		attendance.setUser(null);
//
//		return attendance;
//	}
//
//	public List<GatepassTable> getGatepassTables1() {
//		return this.gatepassTables1;
//	}
//
//	public void setGatepassTables1(List<GatepassTable> gatepassTables1) {
//		this.gatepassTables1 = gatepassTables1;
//	}
//
//	public GatepassTable addGatepassTables1(GatepassTable gatepassTables1) {
//		getGatepassTables1().add(gatepassTables1);
//		gatepassTables1.setUser1(this);
//
//		return gatepassTables1;
//	}
//
//	public GatepassTable removeGatepassTables1(GatepassTable gatepassTables1) {
//		getGatepassTables1().remove(gatepassTables1);
//		gatepassTables1.setUser1(null);
//
//		return gatepassTables1;
//	}
//
//	public List<GatepassTable> getGatepassTables2() {
//		return this.gatepassTables2;
//	}
//
//	public void setGatepassTables2(List<GatepassTable> gatepassTables2) {
//		this.gatepassTables2 = gatepassTables2;
//	}
//
//	public GatepassTable addGatepassTables2(GatepassTable gatepassTables2) {
//		getGatepassTables2().add(gatepassTables2);
//		gatepassTables2.setUser2(this);
//
//		return gatepassTables2;
//	}
//
//	public GatepassTable removeGatepassTables2(GatepassTable gatepassTables2) {
//		getGatepassTables2().remove(gatepassTables2);
//		gatepassTables2.setUser2(null);
//
//		return gatepassTables2;
//	}
//
//	public List<GatepassTable> getGatepassTables3() {
//		return this.gatepassTables3;
//	}
//
//	public void setGatepassTables3(List<GatepassTable> gatepassTables3) {
//		this.gatepassTables3 = gatepassTables3;
//	}
//
//	public GatepassTable addGatepassTables3(GatepassTable gatepassTables3) {
//		getGatepassTables3().add(gatepassTables3);
//		gatepassTables3.setUser3(this);
//
//		return gatepassTables3;
//	}
//
//	public GatepassTable removeGatepassTables3(GatepassTable gatepassTables3) {
//		getGatepassTables3().remove(gatepassTables3);
//		gatepassTables3.setUser3(null);
//
//		return gatepassTables3;
//	}
//
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
//		mark.setUser(this);
//
//		return mark;
////	}
//
//	public Mark removeMark(Mark mark) {
//		getMarks().remove(mark);
//		mark.setUser(null);
//
//		return mark;
//	}
//
//	public Student getStudent() {
//		return this.student;
//	}
//
//	public void setStudent(Student student) {
//		this.student = student;
//	}
//
//	public List<Student> getStudents() {
//		return this.students;
//	}
//
//	public void setStudents(List<Student> students) {
//		this.students = students;
//	}
//
//	public Student addStudent(Student student) {
//		getStudents().add(student);
//		student.setUser2(this);
//
//		return student;
//	}
//
//	public Student removeStudent(Student student) {
//		getStudents().remove(student);
//		student.setUser2(null);
//
//		return student;
//	}
//
//	public StudentSection getStudentSection() {
//		return this.studentSection;
//	}
//
//	public void setStudentSection(StudentSection studentSection) {
//		this.studentSection = studentSection;
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
//		teacher.setUser(this);
//
//		return teacher;
//	}
//
//	public Teacher removeTeacher(Teacher teacher) {
//		getTeachers().remove(teacher);
//		teacher.setUser(null);
//
//		return teacher;
//	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

//	public Warden getWarden() {
//		return this.warden;
//	}
//
//	public void setWarden(Warden warden) {
//		this.warden = warden;
//	}
	
//	public List<UserRole> getUserRoles() {
//		return this.userRoles;
//	}
//
//	public void setUserRoles(List<UserRole> userRoles) {
//		this.userRoles = userRoles;
//	}
//
//	public UserRole addUserRole(UserRole userRole) {
//		getUserRoles().add(userRole);
//		userRole.setUser(this);
//
//		return userRole;
//	}
//
//	public UserRole removeUserRole(UserRole userRole) {
//		getUserRoles().remove(userRole);
//		userRole.setUser(null);
//
//		return userRole;
//	}

}