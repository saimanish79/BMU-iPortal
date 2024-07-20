package com.example.demo.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.GatepassTable;
import com.example.demo.entities.Mark;
import com.example.demo.entities.User;
import com.example.demo.service.GatepassService;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@org.springframework.stereotype.Component
public class WardenWindow {
	
	@Autowired
	GatepassService service;
	
	
	
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
	        
	       User security;
	        
	        User user = gatepass.getUser2();
	        if(gatepass.getUser1()!=null){
	        	security = gatepass.getUser1();
	        }else{
	        	security = new User();
	        	security.setName("null");
	        	security.setUserId("null");
	        }
	        
	        
	        
	        
	        TextField tf2=new TextField();
			tf2.setCaption("Student Name");
			tf2.setValue(String.valueOf(user.getName()));
	        
	        TextField tf3=new TextField();
			tf3.setCaption("Student Reason");
			tf3.setValue(String.valueOf(gatepass.getStudentReason()));
			tf3.setReadOnly(true);
			
	         	 	
	                
	        
	        
			
			TextField rco=new TextField();
			rco.setCaption("Requested CheckOut");
			rco.setValue(String.valueOf(gatepass.getRequestedCheckout()));
			rco.setReadOnly(true);
	        
			
	        TextField rci=new TextField();
	        rci.setCaption("Requested CheckIn");
	        rci.setValue(String.valueOf(gatepass.getRequestedCheckin()));
	        rci.setReadOnly(true);
			
	        
	        TextField aco=new TextField();
	        aco.setCaption("Actual CheckOut");
	        aco.setValue(String.valueOf(gatepass.getActualCheckouttime()));
	        aco.setReadOnly(true);
	        
			
	        TextField aci=new TextField();
	        aci.setCaption("Actual CheckIn");
	        aci.setValue(String.valueOf(gatepass.getActualCheckintime()));
	        aci.setReadOnly(true);
	        
	        TextField securityId=new TextField();
	        securityId.setCaption("Security ID");
	        securityId.setValue(String.valueOf(security.getUserId()));
	        securityId.setReadOnly(true);
	        
	        TextField securityName=new TextField();
	        securityName.setCaption("Security Name");
	        securityName.setValue(String.valueOf(security.getName()));
	        securityName.setReadOnly(true);
	        
	        main.addComponent(tf1);
	        main.addComponent(statusF);
	        main.setComponentAlignment(tf1, Alignment.TOP_CENTER);
	        main.setComponentAlignment(statusF, Alignment.TOP_CENTER);
	        acceptL.addComponent(securityId);
	        rejectL.addComponent(securityName);
	        l1.addComponent(rco);
	        l2.addComponent(rci);
	        l1.addComponent(aco);
	        l2.addComponent(aci);
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



	