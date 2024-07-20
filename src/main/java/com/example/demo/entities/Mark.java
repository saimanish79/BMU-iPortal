package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the MARKS database table.
 * 
 */
@Entity
@Table(name="MARKS")
@NamedQuery(name="Mark.findAll", query="SELECT m FROM Mark m")
public class Mark implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SL_NO")
	private long slNo;

	private BigDecimal marks1;

	private BigDecimal marks2;

	private BigDecimal marks3;

	private BigDecimal marks4;

	private BigDecimal marks5;

	private BigDecimal marks6;

	private BigDecimal marks7;
	
	@Transient
	private String sem;
	
	@Transient
	private String c1;
	
	@Transient
	private String c2;
	
	@Transient
	private String c3;
	
	@Transient
	private String c4;
	
	@Transient
	private String c5;
	
	@Transient
	private String c6;
	
	@Transient
	private String c7;
	
	@Transient
	private double gpa;
	
	
	

	//bi-directional many-to-one association to Section
	@ManyToOne
	@JoinColumn(name="SECTION_ID")
	private Section section;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="STUDENT_ID")
	private User user;

	public Mark() {
	}

	public long getSlNo() {
		return this.slNo;
	}

	public void setSlNo(long slNo) {
		this.slNo = slNo;
	}

	public BigDecimal getMarks1() {
		return this.marks1;
	}

	public void setMarks1(BigDecimal marks1) {
		this.marks1 = marks1;
	}

	public BigDecimal getMarks2() {
		return this.marks2;
	}

	public void setMarks2(BigDecimal marks2) {
		this.marks2 = marks2;
	}

	public BigDecimal getMarks3() {
		return this.marks3;
	}

	public void setMarks3(BigDecimal marks3) {
		this.marks3 = marks3;
	}

	public BigDecimal getMarks4() {
		return this.marks4;
	}

	public void setMarks4(BigDecimal marks4) {
		this.marks4 = marks4;
	}

	public BigDecimal getMarks5() {
		return this.marks5;
	}

	public void setMarks5(BigDecimal marks5) {
		this.marks5 = marks5;
	}

	public BigDecimal getMarks6() {
		return this.marks6;
	}

	public void setMarks6(BigDecimal marks6) {
		this.marks6 = marks6;
	}

	public BigDecimal getMarks7() {
		return this.marks7;
	}

	public void setMarks7(BigDecimal marks7) {
		this.marks7 = marks7;
	}

	public Section getSection() {
		return this.section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getSem()
	{
		return this.section.getSemester();
	}

	public String getC1() {
		return this.section.getCours1().getCourseName();
	}

	public String getC2() {
		return this.section.getCours2().getCourseName();
	}
	
	public String getC3() {
		return this.section.getCours3().getCourseName();
	}
	
	public String getC4() {
		return this.section.getCours4().getCourseName();
	}
	
	public String getC5() {
		return this.section.getCours5().getCourseName();
	}
	
	public String getC6() {
		return this.section.getCours6().getCourseName();
	}
	
	public String getC7() {
		return this.section.getCours7().getCourseName();
	}
	
	public double getGpa()
	{
		double tot=(getMarks1().doubleValue()*getSection().getCours1().getCredits().doubleValue())
				+(getMarks2().doubleValue()*getSection().getCours2().getCredits().doubleValue())
				+(getMarks3().doubleValue()*getSection().getCours3().getCredits().doubleValue())
				+(getMarks4().doubleValue()*getSection().getCours4().getCredits().doubleValue())
				+(getMarks5().doubleValue()*getSection().getCours5().getCredits().doubleValue())
				+(getMarks6().doubleValue()*getSection().getCours6().getCredits().doubleValue())
				+(getMarks7().doubleValue()*getSection().getCours7().getCredits().doubleValue());
		double totc=getSection().getCours1().getCredits().doubleValue()
				+getSection().getCours2().getCredits().doubleValue()
				+getSection().getCours3().getCredits().doubleValue()
				+getSection().getCours4().getCredits().doubleValue()
				+getSection().getCours5().getCredits().doubleValue()
				+getSection().getCours6().getCredits().doubleValue()
				+getSection().getCours7().getCredits().doubleValue();
		return tot/totc;
	}
	
	

}