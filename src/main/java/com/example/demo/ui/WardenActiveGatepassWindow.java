package com.example.demo.ui;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.GatepassTable;
import com.example.demo.entities.Mark;
import com.example.demo.entities.Student;
import com.example.demo.entities.User;
import com.example.demo.service.GatepassService;
import com.example.demo.service.StudentService;
import com.vaadin.server.StreamResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;


import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@org.springframework.stereotype.Component
public class WardenActiveGatepassWindow {
	
	@Autowired
	GatepassService service;
	
	@Autowired
	StudentService studentService;
	
	public class MarkWindowHandler
	{
		public MarkWindowHandler inti()
		{
			return this;
		}
		
		public Component layout(GatepassTable gatepass,User user3,Grid<GatepassTable> grid)
		{
			Window window = new Window();
			window.setHeight("80%");
			window.setWidth("60%");
			window.center();
			window.setCaption(gatepass.getUser2().getName());
			
			VerticalLayout main = new VerticalLayout();
			
			HorizontalLayout root=new HorizontalLayout();
			VerticalLayout l1 = new VerticalLayout();
			VerticalLayout l2 = new VerticalLayout();
			VerticalLayout l3 = new VerticalLayout();
			HorizontalLayout acceptL = new HorizontalLayout();	
			HorizontalLayout rejectL = new HorizontalLayout();
			HorizontalLayout h1= new HorizontalLayout();
			h1.setHeight("100px");
			root.setSizeFull();
			root.setMargin(true);
			root.setHeight("100%");
			
			
			
			TextField tf1=new TextField();
			tf1.setCaption("Gatepass ID");
			tf1.setValue(String.valueOf(gatepass.getGatepassId()));
			tf1.setReadOnly(true);
			
			TextField statusF=new TextField();
			statusF.setCaption("Status");
			statusF.setValue(String.valueOf(gatepass.getStatus()));
			statusF.setReadOnly(true);
	        
	       
	        
	        User user = gatepass.getUser2();
	        
	        
	        TextField tf2=new TextField();
			tf2.setCaption("Student Name");
			tf2.setValue(String.valueOf(user.getName()));
	        
	        TextField tf3=new TextField();
			tf3.setCaption("Student Reason");
			tf3.setValue(String.valueOf(gatepass.getStudentReason()));
			tf3.setReadOnly(true);
			
	         	 	
	                
	        TextField studentIP=new TextField();
	        studentIP.setCaption("Student IP");
	        studentIP.setValue(String.valueOf(gatepass.getStudentIp()));
	        studentIP.setReadOnly(true);
	        
			
	        TextField parentIP=new TextField();
			parentIP.setCaption("Parent IP");
			parentIP.setValue(String.valueOf(gatepass.getParentIp()));
			parentIP.setReadOnly(true);
	        
			
			TextField rco=new TextField();
			rco.setCaption("Requested CheckOut");
			rco.setValue(String.valueOf(gatepass.getRequestedCheckout()));
			rco.setReadOnly(true);
	        
			
	        TextField rci=new TextField();
	        rci.setCaption("Requested CheckIn");
	        rci.setValue(String.valueOf(gatepass.getRequestedCheckin()));
	        rci.setReadOnly(true);
			
			
	        
	        Button accept = new Button(" Accept ");
	        accept.setWidth("70px");
	        accept.setStyleName("blue-button-style");
	        accept.addClickListener(new Button.ClickListener() {
	        	
	        	Long time = System.currentTimeMillis();
				Date resultdate = new Date(time);
				
				@Override
				public void buttonClick(ClickEvent event) {
					gatepass.setStatus("Warden Approved");
					gatepass.setWardenApprovedtime(resultdate);
					gatepass.setUser3(user3);
					service.addgatepass(gatepass);
					grid.getDataProvider().refreshAll();
					window.close();
					
				}
	        	
	        });
	        
	        
	        
	        Button reject = new Button(" Reject ");
	        reject.setWidth("70px");
	        reject.setStyleName("red-button-style");
	        reject.addClickListener(new Button.ClickListener() {

	        	
				
				@Override
				public void buttonClick(ClickEvent event) {
					gatepass.setStatus("Warden Rejected");
					service.addgatepass(gatepass);
					grid.getDataProvider().refreshAll();
					window.close();
					
				}
	        	
	        });
	        Student student=studentService.getStudent(user.getUserId());
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
	        
	        l3.addComponent(tf1);
	        l3.addComponent(statusF);
	        h1.addComponent(l3);
	        h1.addComponent(i);
	        h1.setComponentAlignment(l3, Alignment.MIDDLE_CENTER);
	        h1.setComponentAlignment(i, Alignment.MIDDLE_RIGHT);
	        main.addComponent(h1);
	        l1.addComponents(tf2,studentIP);
	        l2.addComponents(tf3,parentIP);
	        acceptL.addComponent(accept);
	        rejectL.addComponent(reject);
	        acceptL.setMargin(true);
	        rejectL.setMargin(true);
	        l1.addComponent(rco);
	        l2.addComponent(rci);
	        l1.addComponent(acceptL);
	        l2.addComponent(rejectL);
			root.addComponent(l1);
			root.addComponent(l2);
			
	       main.addComponent(root);
			
			window.setContent(main);
			return window;
		}
	}
	
	public Component createComponent(GatepassTable gatepass,User user,Grid<GatepassTable> grid)
	{
		return new MarkWindowHandler().inti().layout(gatepass,user,grid);
	}

}


