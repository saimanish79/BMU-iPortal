package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the WARDEN database table.
 * 
 */
@Entity
@NamedQuery(name="Warden.findAll", query="SELECT w FROM Warden w")
public class Warden implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="WARDEN_ID")
	private String wardenId;

	private String hosteltype;

	private String name;

	//bi-directional one-to-one association to User
	@OneToOne
	@JoinColumn(name="WARDEN_ID")
	private User user;

	public Warden() {
	}

	public String getWardenId() {
		return this.wardenId;
	}

	public void setWardenId(String wardenId) {
		this.wardenId = wardenId;
	}

	public String getHosteltype() {
		return this.hosteltype;
	}

	public void setHosteltype(String hosteltype) {
		this.hosteltype = hosteltype;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}