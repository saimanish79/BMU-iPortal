package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the STUDENT_SECTIONS database table.
 * 
 */
@Entity
@Table(name="STUDENT_SECTIONS")
@NamedQuery(name="StudentSection.findAll", query="SELECT s FROM StudentSection s")
public class StudentSection implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="STUDENT_ID")
	private String studentId;

	//bi-directional many-to-one association to Section
	@ManyToOne
	@JoinColumn(name="SEC1")
	private Section section1;

	//bi-directional many-to-one association to Section
	@ManyToOne
	@JoinColumn(name="SEC2")
	private Section section2;

	//bi-directional many-to-one association to Section
	@ManyToOne
	@JoinColumn(name="SEC3")
	private Section section3;

	//bi-directional many-to-one association to Section
	@ManyToOne
	@JoinColumn(name="SEC4")
	private Section section4;

	//bi-directional many-to-one association to Section
	@ManyToOne
	@JoinColumn(name="SEC5")
	private Section section5;

	//bi-directional many-to-one association to Section
	@ManyToOne
	@JoinColumn(name="SEC6")
	private Section section6;

	//bi-directional many-to-one association to Section
	@ManyToOne
	@JoinColumn(name="SEC7")
	private Section section7;

	//bi-directional many-to-one association to Section
	@ManyToOne
	@JoinColumn(name="SEC8")
	private Section section8;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="STUDENT_ID")
	private User user;

	public StudentSection() {
	}

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public Section getSection1() {
		return this.section1;
	}

	public void setSection1(Section section1) {
		this.section1 = section1;
	}

	public Section getSection2() {
		return this.section2;
	}

	public void setSection2(Section section2) {
		this.section2 = section2;
	}

	public Section getSection3() {
		return this.section3;
	}

	public void setSection3(Section section3) {
		this.section3 = section3;
	}

	public Section getSection4() {
		return this.section4;
	}

	public void setSection4(Section section4) {
		this.section4 = section4;
	}

	public Section getSection5() {
		return this.section5;
	}

	public void setSection5(Section section5) {
		this.section5 = section5;
	}

	public Section getSection6() {
		return this.section6;
	}

	public void setSection6(Section section6) {
		this.section6 = section6;
	}

	public Section getSection7() {
		return this.section7;
	}

	public void setSection7(Section section7) {
		this.section7 = section7;
	}

	public Section getSection8() {
		return this.section8;
	}

	public void setSection8(Section section8) {
		this.section8 = section8;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}