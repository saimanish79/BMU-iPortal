package com.example.demo.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;


/**
 * The persistent class for the GATEPASS_TABLE database table.
 * 
 */
@Entity
@Table(name="GATEPASS_TABLE")
@NamedQuery(name="GatepassTable.findAll", query="SELECT g FROM GatepassTable g")
public class GatepassTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="GATEPASS_TABLE_gen")
	@SequenceGenerator(name="GATEPASS_TABLE_gen",sequenceName="GATEPASS_TABLE_SEQ",initialValue=1,allocationSize=1)	
	
	@Column(name="GATEPASS_ID")
	private long gatepassId;

	@Column(name="ACTUAL_CHECKINTIME")
	private Date actualCheckintime;

	@Column(name="ACTUAL_CHECKOUTTIME")
	private Date actualCheckouttime;

	private String attribute1;

	private String attribute2;

	private String attribute3;

	private BigDecimal attribute4;

	private String column22;

	@Column(name="PARENT_APPROVEDTIME")
	private Date parentApprovedtime;

	@Column(name="PARENT_IP")
	private String parentIp;

	@Column(name="PARENT_REASON")
	private String parentReason;

	@Column(name="REQUESTED_CHECKIN")
	private Date requestedCheckin;

	@Column(name="REQUESTED_CHECKOUT")
	private Date requestedCheckout;

	@Column(name="REQUESTED_TIME")
	private Date requestedTime;

//	@Column(name="SECURITY_ID")
//	private String securityId;

	private String status;

//	@Column(name="STUDENT_ID")
//	private String studentId;

	@Column(name="STUDENT_IP")
	private String studentIp;

	@Column(name="STUDENT_REASON")
	private String studentReason;

	@Column(name="WARDEN_APPROVEDTIME")
	private Date wardenApprovedtime;

//	@Column(name="WARDEN_ID")
//	private String wardenId;

	@Column(name="WARDEN_REASON")
	private String wardenReason;
	
	//bi-directional many-to-one association to User
		@ManyToOne
		@JoinColumn(name="SECURITY_ID")
		private User user1;

		//bi-directional many-to-one association to User
		@ManyToOne
		@JoinColumn(name="STUDENT_ID")
		private User user2;

		//bi-directional many-to-one association to User
		@ManyToOne
		@JoinColumn(name="WARDEN_ID")
		private User user3;
		
		@Transient
		private String sid;
		
		@Transient
		private String sname;

	
	public GatepassTable() {
	}

	public long getGatepassId() {
		return this.gatepassId;
	}

	public void setGatepassId(long gatepassId) {
		this.gatepassId = gatepassId;
	}

	public Date getActualCheckintime() {
		return this.actualCheckintime;
	}

	public void setActualCheckintime(Date actualCheckintime) {
		this.actualCheckintime = actualCheckintime;
	}

	public Date getActualCheckouttime() {
		return this.actualCheckouttime;
	}

	public void setActualCheckouttime(Date actualCheckouttime) {
		this.actualCheckouttime = actualCheckouttime;
	}

	public String getAttribute1() {
		return this.attribute1;
	}

	public void setAttribute1(String attribute1) {
		this.attribute1 = attribute1;
	}

	public String getAttribute2() {
		return this.attribute2;
	}

	public void setAttribute2(String attribute2) {
		this.attribute2 = attribute2;
	}

	public String getAttribute3() {
		return this.attribute3;
	}

	public void setAttribute3(String attribute3) {
		this.attribute3 = attribute3;
	}

	public BigDecimal getAttribute4() {
		return this.attribute4;
	}

	public void setAttribute4(BigDecimal attribute4) {
		this.attribute4 = attribute4;
	}

	public String getColumn22() {
		return this.column22;
	}

	public void setColumn22(String column22) {
		this.column22 = column22;
	}

	public Date getParentApprovedtime() {
		return this.parentApprovedtime;
	}

	public void setParentApprovedtime(Date parentApprovedtime) {
		this.parentApprovedtime = parentApprovedtime;
	}

	public String getParentIp() {
		return this.parentIp;
	}

	public void setParentIp(String parentIp) {
		this.parentIp = parentIp;
	}

	public String getParentReason() {
		return this.parentReason;
	}

	public void setParentReason(String parentReason) {
		this.parentReason = parentReason;
	}

	public Date getRequestedCheckin() {
		return this.requestedCheckin;
	}

	public void setRequestedCheckin(Date requestedCheckin) {
		this.requestedCheckin = requestedCheckin;
	}

	public Date getRequestedCheckout() {
		return this.requestedCheckout;
	}

	public void setRequestedCheckout(Date requestedCheckout) {
		this.requestedCheckout = requestedCheckout;
	}

	public Date getRequestedTime() {
		return this.requestedTime;
	}

	public void setRequestedTime(Date requestedTime) {
		this.requestedTime = requestedTime;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getStudentIp() {
		return this.studentIp;
	}

	public void setStudentIp(String studentIp) {
		this.studentIp = studentIp;
	}

	public String getStudentReason() {
		return this.studentReason;
	}

	public void setStudentReason(String studentReason) {
		this.studentReason = studentReason;
	}

	public Date getWardenApprovedtime() {
		return this.wardenApprovedtime;
	}

	public void setWardenApprovedtime(Date wardenApprovedtime) {
		this.wardenApprovedtime = wardenApprovedtime;
	}


	public String getWardenReason() {
		return this.wardenReason;
	}

	public void setWardenReason(String wardenReason) {
		this.wardenReason = wardenReason;
	}
	
	public User getUser1() {
		return user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public User getUser3() {
		return user3;
	}

	public void setUser3(User user3) {
		this.user3 = user3;
	}
	
	public String getSid()
	{
		return user2.getUserId();
	}

	public String getSname()
	{
		return user2.getName();
	}

}
