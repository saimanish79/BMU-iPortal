package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the TEACHER database table.
 * 
 */
@Entity
@NamedQuery(name="Teacher.findAll", query="SELECT t FROM Teacher t")
public class Teacher implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SL_NO")
	private String slNo;

	//bi-directional many-to-one association to Section
	@ManyToOne
	@JoinColumn(name="SECTION_ID")
	private Section section;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="TEACHER_ID")
	private User user;

	public Teacher() {
	}

	public String getSlNo() {
		return this.slNo;
	}

	public void setSlNo(String slNo) {
		this.slNo = slNo;
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

}