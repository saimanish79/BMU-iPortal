package com.example.demo.ui;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;


import com.example.demo.entities.Student;
import com.example.demo.entities.User;
import com.example.demo.service.StudentService;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@org.springframework.stereotype.Component
public class DetailsView {
	
	@Autowired
	StudentService studentService;
	
	public Student student;
	
	
	
	public class StudentDetailHandler
	{
		public StudentDetailHandler init()
		{
			return this;
		}
		
		public Component layout(String id)
		{
			student=studentService.getStudent(id);
			VerticalLayout root=new VerticalLayout();
			root.setSizeFull();
			root.setMargin(true);
			root.setHeight("100%");
			
			
			Panel panel=new Panel("Student details");
			panel.setSizeFull();
			
			root.addComponent(panel);
			root.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
			

			
		    HorizontalLayout form=new HorizontalLayout();
			form.setSizeFull();
			
			
			FormLayout formLayout1=new FormLayout();
			form.addComponent(formLayout1);
			
			FormLayout formLayout2=new FormLayout();
			form.addComponent(formLayout2);
			
			

			TextField tf1=new TextField("Student ID:");
			tf1.setValue(student.getStudentId());
			formLayout1.addComponent(tf1);
			tf1.setEnabled(false);
			
			
			TextField tf2=new TextField("Name:");
			tf2.setValue(student.getName());
			formLayout1.addComponent(tf2);
			tf2.setEnabled(false);
			
			
			DateField date = new DateField("DOB:");
			formLayout1.addComponent(date);
			try{
			Instant instant = Instant.ofEpochMilli(student.getBirthDate().getTime()); 
			LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault()); 
			LocalDate localDate = localDateTime.toLocalDate();
			date.setValue(localDate);
			}
			catch(Exception e)
			{
				
			}
			
		
			TextField tf3=new TextField("Phone Number:");
			formLayout1.addComponent(tf3);
			try{
			tf3.setValue(student.getPhoneNo());
			}
			catch(Exception e)
			{
				
			}
		
		     
			TextArea address = new TextArea("Address:");   
			formLayout1.addComponent(address); 
			try{
			address.setValue(student.getAddress());
			}
			catch(Exception e)
			{
				
			}
			

			TextField nationality = new TextField("Nationality");
			formLayout1.addComponent(nationality);
			try{
			nationality.setValue(student.getNationality());
			}
			catch(Exception e)
			{
				
			}
			
			
			TextField tf4=new TextField("Aadhar Number:");
			formLayout1.addComponent(tf4);
			try{
			tf4.setValue(student.getAadhar());
			}
			catch(Exception e)
			{
				
			}
			
			
			TextField tf5=new TextField("Parent Name:");
			formLayout2.addComponent(tf5);
			tf5.setValue(student.getUser2().getName());
			tf5.setEnabled(false);
			
			
			TextField tf6=new TextField("Parent Phone Number:");
			formLayout2.addComponent(tf6);
			try{
			tf6.setValue(student.getParentPhone());
			tf6.setEnabled(false);
			}
			catch(Exception e)
			{
				
			}
		    
			
			TextField tf7=new TextField("Batch:");
			formLayout2.addComponent(tf7);
			try{
			tf7.setValue(student.getBatch());
			tf7.setEnabled(false);
			}
			catch(Exception e)
			{
				
			}
			
			
			
	       ComboBox<String>comboBox=new ComboBox<>("Department:");
			
			comboBox.setItems("CSC","CSE","ECE","ME","CIV");
		    comboBox.setWidthUndefined();
			formLayout2.addComponent(comboBox);
			try{
			comboBox.setValue(student.getDept());
			comboBox.setEnabled(false);
			}
			catch(Exception e)
			{
				
			}
			
			
//			 Receiver receiver = null;
//				Upload upload = new Upload("Upload Photo", receiver);
//			      upload.setImmediateMode(true);
//			      formLayout2.addComponent(upload);
			      
			StreamResource.StreamSource source = new StreamResource.StreamSource() {
	            
	            public InputStream getStream() {
	            return new ByteArrayInputStream(student.getPhoto());
//	            	return null;
	            }
	    };
	        StreamResource sr = new StreamResource( source, "");
	       Image i= new Image();
	        i.setSource(sr);
	        i.setWidth("200px");
	        i.setHeight("150px");
	        formLayout2.addComponent(i);
			  
			      
			  Button button=new Button("Update");
			  formLayout2.addComponent(button);
			  button.setWidth("30%");
			      
			button.addClickListener(new Button.ClickListener() {
				
				@Override
				public void buttonClick(ClickEvent event) {
					// TODO Auto-generated method stub
					
					student.setStudentId(tf1.getValue());
					student.setName(tf2.getValue());
					student.setBirthDate(Date.valueOf(date.getValue()));
					student.setPhoneNo(tf3.getValue());
					student.setAddress(address.getValue());
					student.setNationality(nationality.getValue());
					student.setAadhar(tf4.getValue());
					User u=student.getUser2();
					u.setName(tf5.getValue());
					student.setUser2(u);
					student.setParentPhone(tf6.getValue());
					student.setBatch(tf7.getValue());
					student.setDept(comboBox.getValue());
					
					studentService.addStudent(student);
					Notification.show("Data Saved Sucessfully");
				}
			});
		      
		      
		      panel.setContent(form);
		      return root;
		}
		
		
	}
	
	public Component createComponent(String id){
		return new StudentDetailHandler().init().layout(id);
	}

}
