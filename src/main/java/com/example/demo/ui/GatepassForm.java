package com.example.demo.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.example.demo.entities.GatepassTable;
import com.example.demo.entities.Student;
import com.example.demo.entities.User;
import com.example.demo.service.GatepassService;
import com.example.demo.service.StudentService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateTimeField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

import oracle.sql.DATE;
@org.springframework.stereotype.Component

public class GatepassForm {
	
	@Autowired
	GatepassService service;
	
	@Autowired
    private JavaMailSender sender;
	
	String sreason;
	
	String parentmail;
	
	String from;
	String to;
	
	GatepassTable gatepass = new GatepassTable();
	
	User user2;
	
	Student student;
	
	String parentEmail;
	
	String ipaddress;
	
	String ip;
	
	@Autowired
	StudentService studentservice;
	
	
	
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");
	
	 
//	BeanFieldGroup<gatepass> fieldGroup = new BeanFieldGroup<>(GatepassTable.class);
	
	
	
	
	public class gatepassform
	{
		
		
		public gatepassform init()
		{
			
			return this;
		}
		
		public Component layout(User currentUser)
		{
			String currentUserName = currentUser.getName();
			String currentUserNumber = currentUser.getUserId();
			student= studentservice.getStudent(currentUser.getUserId());
			user2=student.getUser1();
			FormLayout root = new FormLayout();
			
			root.setMargin(true);
			
			TextField name = new TextField();
			name.setCaption("Name:");
			name.setValue(currentUserName);
			name.setEnabled(false);
			
			
			root.addComponent(name);
			
			
			
			
			Label id = new Label();
			id.setCaption("Registration Number:");
			id.setValue(currentUserNumber);
			
			root.addComponent(id);
			
			//Reason
			TextArea reason = new TextArea();
			reason.setCaption("Reason");
			reason.setWidth("400px");
			reason.setHeight("100px");
			root.addComponent(reason);
			


			
			
			//date time field
			DateTimeField sample = new DateTimeField();
			sample.setCaption("Checkout Time");
	        
			
			
			
			root.addComponent(sample);
			
			
			
			
			DateTimeField sample1 = new DateTimeField();
			sample1.setCaption("CheckIn Time");
	        
			
	        
	        root.addComponent(sample1);
	        
	        
	        
	        
	        
	        
//	       fieldGroup.bind(,);
	        
	        //button
			
	        
			Button button = new Button("submit");
			button.addClickListener(new Button.ClickListener() {

				@Override
				public void buttonClick(ClickEvent event) {
					sreason = reason.getValue();
					Long time = System.currentTimeMillis();
					Date resultdate = new Date(time);
					
//					from = ((DateField) sample).format(formatter);
					
					if(!sample.isEmpty() && !sample1.isEmpty())
					{
					ZoneId defaultZoneId = ZoneId.systemDefault();
					Date date1 = new Date(Date.from(sample1.getValue().atZone(defaultZoneId).toInstant()).getTime());
					Date date2 =  new Date(Date.from(sample.getValue().atZone(defaultZoneId).toInstant()).getTime());
					//gatepass.setGatepassId("100");
					
					if(!reason.getValue().equals(null) && resultdate.compareTo(date2)<0 &&
							date2.compareTo(date1)<0 && resultdate.compareTo(date1)<0
							)
					{
					gatepass.setStudentReason(reason.getValue());
					
					gatepass.setRequestedCheckin(date1);
					
					gatepass.setRequestedCheckout(date2);				
					gatepass.setUser2(user2);
					gatepass.setStatus("Initiated");
					gatepass.setRequestedTime(resultdate);
					
					try{
					URL whatismyip = new URL("http://checkip.amazonaws.com");
					BufferedReader in = new BufferedReader(new InputStreamReader(
					                whatismyip.openStream()));

					ip = in.readLine(); //you get the IP as a String
					System.out.println(ip);
					}
					catch(Exception e)
					{
						
					}
					
					//gatepass.setStudentIp(ip);
					
					
					try {
						InetAddress ip = InetAddress.getLocalHost();
						ipaddress = ip.toString();
						//root.addComponent(new Label(ipaddress));
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					ipaddress=ipaddress+"/"+ip;
					
					gatepass.setStudentIp(ipaddress);
					
					
					service.addgatepass(gatepass);
					
					try {
						sendEmail(student.getUser2().getEmailid());
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					Notification.show("Request Sucessful",
			                  "Your request has been submitted sucessfully",
			                  Notification.Type.HUMANIZED_MESSAGE);
					reason.clear();
					sample1.clear();
					sample.clear();
					}
					else
					{
						Notification.show("Error",
				                  "Wrong details",
				                  Notification.Type.HUMANIZED_MESSAGE);
					}
				}
					else
					{
						Notification.show("Error",
				                  "Select date and time",
				                  Notification.Type.HUMANIZED_MESSAGE);
					}
				}
				
				
			});
			
			
			
				
			
			
			
			
				
//				@Override
//				public void buttonClick(ClickEvent event) {
////					HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
////					        .getRequest();
	////
////					String ip = request.getRemoteAddr();
//					
//					try {
//						InetAddress ip = InetAddress.getLocalHost();
//						String ipaddress = ip.toString();
//						root.addComponent(new Label(ipaddress));
//					} catch (UnknownHostException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
	//
//				@Override
//				public void buttonClick(ClickEvent event) {
//					// TODO Auto-generated method stub
//					
//				}
//			});
			root.addComponent(button);
			return root;
		}
		

}
	
	private void sendEmail(String mail) throws Exception{
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        
        String text;
        text = "Dear parent, Your Child has raised a request for gatepass to leave "
        		+ "the campus. Please take action. </br> Reason: "+sreason + "Please follow the below link and login to portal."
        				+ "http://localhost:9090/login";
        
        
        helper.setTo(mail);
        helper.setText(text,true);
        helper.setSubject("Subject");
        
        sender.send(message);
    }
	
public Component createComponent(User user){
	return new gatepassform().init().layout(user);
}

}
