package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the COURSES database table.
 * 
 */
@Entity
@Table(name="COURSES")
@NamedQuery(name="Cours.findAll", query="SELECT c FROM Cours c")
public class Cours implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="COURSE_ID")
	private String courseId;

	@Column(name="COURSE_NAME")
	private String courseName;

	private BigDecimal credits;

//	//bi-directional many-to-one association to Attendance
//	@OneToMany(mappedBy="cours")
//	private List<Attendance> attendances;

//	//bi-directional many-to-one association to Section
//	@OneToMany(mappedBy="cours1")
//	private List<Section> sections1;
//
//	//bi-directional many-to-one association to Section
//	@OneToMany(mappedBy="cours2")
//	private List<Section> sections2;
//
//	//bi-directional many-to-one association to Section
//	@OneToMany(mappedBy="cours3")
//	private List<Section> sections3;
//
//	//bi-directional many-to-one association to Section
//	@OneToMany(mappedBy="cours4")
//	private List<Section> sections4;
//
//	//bi-directional many-to-one association to Section
//	@OneToMany(mappedBy="cours5")
//	private List<Section> sections5;
//
//	//bi-directional many-to-one association to Section
//	@OneToMany(mappedBy="cours6")
//	private List<Section> sections6;
//
//	//bi-directional many-to-one association to Section
//	@OneToMany(mappedBy="cours7")
//	private List<Section> sections7;

	public Cours() {
	}

	public String getCourseId() {
		return this.courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public BigDecimal getCredits() {
		return this.credits;
	}

	public void setCredits(BigDecimal credits) {
		this.credits = credits;
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
//		attendance.setCours(this);
//
//		return attendance;
//	}
//
//	public Attendance removeAttendance(Attendance attendance) {
//		getAttendances().remove(attendance);
//		attendance.setCours(null);
//
//		return attendance;
//	}
//
//	public List<Section> getSections1() {
//		return this.sections1;
//	}
//
//	public void setSections1(List<Section> sections1) {
//		this.sections1 = sections1;
//	}
//
//	public Section addSections1(Section sections1) {
//		getSections1().add(sections1);
//		sections1.setCours1(this);
//
//		return sections1;
//	}
//
//	public Section removeSections1(Section sections1) {
//		getSections1().remove(sections1);
//		sections1.setCours1(null);
//
//		return sections1;
//	}
//
//	public List<Section> getSections2() {
//		return this.sections2;
//	}
//
//	public void setSections2(List<Section> sections2) {
//		this.sections2 = sections2;
//	}
//
//	public Section addSections2(Section sections2) {
//		getSections2().add(sections2);
//		sections2.setCours2(this);
//
//		return sections2;
//	}
//
//	public Section removeSections2(Section sections2) {
//		getSections2().remove(sections2);
//		sections2.setCours2(null);
//
//		return sections2;
//	}
//
//	public List<Section> getSections3() {
//		return this.sections3;
//	}
//
//	public void setSections3(List<Section> sections3) {
//		this.sections3 = sections3;
//	}
//
//	public Section addSections3(Section sections3) {
//		getSections3().add(sections3);
//		sections3.setCours3(this);
//
//		return sections3;
//	}
//
//	public Section removeSections3(Section sections3) {
//		getSections3().remove(sections3);
//		sections3.setCours3(null);
//
//		return sections3;
//	}
//
//	public List<Section> getSections4() {
//		return this.sections4;
//	}
//
//	public void setSections4(List<Section> sections4) {
//		this.sections4 = sections4;
//	}
//
//	public Section addSections4(Section sections4) {
//		getSections4().add(sections4);
//		sections4.setCours4(this);
//
//		return sections4;
//	}
//
//	public Section removeSections4(Section sections4) {
//		getSections4().remove(sections4);
//		sections4.setCours4(null);
//
//		return sections4;
//	}
//
//	public List<Section> getSections5() {
//		return this.sections5;
//	}
//
//	public void setSections5(List<Section> sections5) {
//		this.sections5 = sections5;
//	}
//
//	public Section addSections5(Section sections5) {
//		getSections5().add(sections5);
//		sections5.setCours5(this);
//
//		return sections5;
//	}
//
//	public Section removeSections5(Section sections5) {
//		getSections5().remove(sections5);
//		sections5.setCours5(null);
//
//		return sections5;
//	}
//
//	public List<Section> getSections6() {
//		return this.sections6;
//	}
//
//	public void setSections6(List<Section> sections6) {
//		this.sections6 = sections6;
//	}
//
//	public Section addSections6(Section sections6) {
//		getSections6().add(sections6);
//		sections6.setCours6(this);
//
//		return sections6;
//	}
//
//	public Section removeSections6(Section sections6) {
//		getSections6().remove(sections6);
//		sections6.setCours6(null);
//
//		return sections6;
//	}
//
//	public List<Section> getSections7() {
//		return this.sections7;
//	}
//
//	public void setSections7(List<Section> sections7) {
//		this.sections7 = sections7;
//	}
//
//	public Section addSections7(Section sections7) {
//		getSections7().add(sections7);
//		sections7.setCours7(this);
//
//		return sections7;
//	}
//
//	public Section removeSections7(Section sections7) {
//		getSections7().remove(sections7);
//		sections7.setCours7(null);
//
//		return sections7;
//	}

}