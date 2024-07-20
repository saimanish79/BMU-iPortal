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
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@org.springframework.stereotype.Component
public class SecurityWindow {
	
	@Autowired
	GatepassService service;
	
	@Autowired
	StudentService studentService;
	
	
    
    String status;
	
	public class MarkWindowHandler
	{
		public MarkWindowHandler inti()
		{
			return this;
		}
		
		public Component layout(GatepassTable gatepass)
		{
			Window window = new Window();
			window.setHeight("80%");
			window.setWidth("60%");
			window.center();
			window.setCaption(gatepass.getUser2().getName());
			VerticalLayout root=new VerticalLayout();
			root.setSizeFull();
			root.setMargin(true);
			root.setHeight("100%");
			
            
			
            status = gatepass.getStatus();
            
            Student student=studentService.getStudent(gatepass.getUser2().getUserId());
            
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
            
	       
			root.addComponents(i);
			root.setComponentAlignment(i, Alignment.MIDDLE_CENTER);
			Button button1 = new Button();
			
			if(status.equals("Warden Approved")){
				button1.setStyleName("green-button-style");
				button1.setCaption("Check Out");
			}
			if(status.equals("Check Out")){
				button1.setCaption("Check In");
			}
			
//			Button button2 = new Button();
//			button1.setCaption("Check Out");
			
			button1.addClickListener(e ->{
				Long time = System.currentTimeMillis();
				SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY HH:mm a");
				String formattedDate = df.format(time);
				Date resultdate = new Date(time);
				
				
				
				System.out.println(formattedDate);
				
				if(status.equals("Warden Approved")){
					Notification.show("Status",
			                  "Check out is sucessful",
			                  Notification.Type.HUMANIZED_MESSAGE);
					gatepass.setActualCheckouttime(resultdate);
					gatepass.setStatus("Check Out");
					service.addgatepass(gatepass);
					window.close();
					
				}
				if(status.equals("Check Out")){
					Notification.show("Status",
			                  "Check In is sucessful",
			                  Notification.Type.HUMANIZED_MESSAGE);
					gatepass.setActualCheckintime(resultdate);;
					gatepass.setStatus("Check In");
					service.addgatepass(gatepass);
					window.close();
				}
				
			});
			
//			button2.addClickListener(e ->{
//				Long time = System.currentTimeMillis();
//				SimpleDateFormat df = new SimpleDateFormat("MM/dd/YYYY HH:mm a");
//				String formattedDate = df.format(time);
//				System.out.println(formattedDate);
//				
//			});
			
			root.addComponent(button1);
			root.setComponentAlignment(button1, Alignment.MIDDLE_CENTER);
			window.setContent(root);
			return window;
		}
	}
	
	public Component createComponent(GatepassTable gatepass)
	{
		return new MarkWindowHandler().inti().layout(gatepass);
	}

}