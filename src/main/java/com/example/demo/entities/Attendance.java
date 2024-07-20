package com.example.demo.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the ATTENDANCE database table.
 * 
 */
@Entity
@NamedQuery(name="Attendance.findAll", query="SELECT a FROM Attendance a")
public class Attendance implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SL_NO")
	private long slNo;

	@Column(name="ATT_DATE")
	private Timestamp attDate;

	private String status;
	
	@Transient
	private String course;

	//bi-directional many-to-one association to Cours
	@ManyToOne
	@JoinColumn(name="COURSE_ID")
	private Cours cours;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	private User user;

	public Attendance() {
	}

	public long getSlNo() {
		return this.slNo;
	}

	public void setSlNo(long slNo) {
		this.slNo = slNo;
	}

	public Timestamp getAttDate() {
		return this.attDate;
	}

	public void setAttDate(Timestamp attDate) {
		this.attDate = attDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cours getCours() {
		return this.cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getCourse()
	{
		return this.cours.getCourseName();
	}

}