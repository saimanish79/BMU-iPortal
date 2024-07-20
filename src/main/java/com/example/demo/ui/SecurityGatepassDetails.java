package com.example.demo.ui;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.GatepassTable;
import com.example.demo.entities.User;
import com.example.demo.service.GatepassService;
import com.example.demo.service.StudentService;
import com.sun.tools.xjc.model.CElementPropertyInfo.CollectionMode;
//import com.example.demo.entities.Attendance;
//import com.example.demo.service.StudentService;
//import com.example.demo.ui.AttendanceView.AttendanceHandler;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateTimeField;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;
import com.vaadin.ui.Button.ClickEvent;

@org.springframework.stereotype.Component
public class SecurityGatepassDetails {
	
	@Autowired
	GatepassService service;
	
	@Autowired
	GatepassWindow gatepassWindow;
	
	@Autowired
	WardenWindow wardenWindow;
	
	@Autowired
	StudentService studentService;

	@Autowired
	SecurityWindow securityWindow;
	
	@Autowired
	SecurityWindow2 securityWindow2;
	
	@Autowired 
	SecurityWindow3 securityWindow3;
	
	Long gatepassId;
	String gatepassIdString;
	String status;
	String remark;
	
	GatepassTable gatepass;
	
	public class gatepassHandler
	{
		
		public gatepassHandler init()
		{
			return this;
		}
		
		public Component layout(User user)
		{
			HorizontalLayout root = new HorizontalLayout();
			VerticalLayout layout2=new VerticalLayout();
//			layout2.setSizeFull();
			
			
			TextField tv = new TextField();
			tv.setCaption("Enter Gatepass ID: ");
			
			layout2.setMargin(true);
			
			
			tv.addValueChangeListener(event ->
	        // Do something with the value
	        gatepassIdString = event.getValue());
			Label statusText = new Label();
			Button button = new Button();
			button.setCaption("Search");
			
			button.addClickListener(e ->{
				Long time = System.currentTimeMillis();
				Date resultdate = new Date(time);
				
				System.out.println("dsf");
				gatepassIdString = tv.getValue();
				gatepassId = Long.valueOf(gatepassIdString).longValue();
				gatepass = service.findOneGatepass(gatepassId);
				gatepass.setUser1(user);
				status = gatepass.getStatus();
				
				
				Date checkoutTime = new Date(gatepass.getRequestedCheckout().getTime());
				
				System.out.println("bool: "+checkoutTime.compareTo(resultdate));
				
				
				if(status.equals("Warden Approved") && checkoutTime.compareTo(resultdate)>0){
					UI.getCurrent().addWindow((Window) securityWindow3.createComponent());
				}
				
				else{
				if(status.equals("Warden Approved") || status.equals("Check Out")){
					
					UI.getCurrent().addWindow((Window) securityWindow.createComponent(gatepass));
					
				}
				}
				if(status.equals("Warden Rejected") || status.equals("Parent Rejected") 
						|| status.equals("IP Conflict") || status.equals("Initiated") || 
						status.equals("Parent Approved")){
					UI.getCurrent().addWindow((Window) securityWindow2.createComponent());
					service.addgatepass(gatepass);
					System.out.println("hello2");
				}
				if(status.equals("Check In"))
				{
					Notification.show("Status",
			                  "Gatepass Closed",
			                  Notification.Type.HUMANIZED_MESSAGE);
				}
				
				statusText.setValue(remark);
				
			});
			
			
			
			layout2.addComponent(tv);
			layout2.addComponent(button);
			layout2.addComponent(statusText);
			
			layout2.setComponentAlignment(tv, Alignment.MIDDLE_CENTER);
			
			root.addComponent(layout2);
			
			
			
			
			
			return root;
		}
		

}
	
public Component createComponent(User user){
	return new gatepassHandler().init().layout(user);
}
}
