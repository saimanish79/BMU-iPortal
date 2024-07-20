package com.example.demo.ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
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
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@org.springframework.stereotype.Component
public class GatepassWindow {
	
	@Autowired
	GatepassService service;
	
	String ipaddress;
	String studentip;
	
	String[] ips1=new String[3];
	String[] ips2=new String[3];
	String ip;
	
	public class MarkWindowHandler
	{
		public MarkWindowHandler inti()
		{
			return this;
		}
		
		public Component layout(GatepassTable gatepass,Grid<GatepassTable> grid)
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
	        
	        Button accept = new Button("Accept");
	        accept.setWidth("70px");
	        accept.setStyleName("green-button-style");
	        accept.addClickListener(new Button.ClickListener() {
	        	
	        	Long time = System.currentTimeMillis();
				Date resultdate = new Date(time);
				
				@Override
				public void buttonClick(ClickEvent event) {
					try {
						InetAddress ip = InetAddress.getLocalHost();
						ipaddress = ip.toString();
//						root.addComponent(new Label(ipaddress));
					} catch (UnknownHostException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				studentip = gatepass.getStudentIp();
					
					try{
						URL whatismyip = new URL("http://checkip.amazonaws.com");
						BufferedReader in = new BufferedReader(new InputStreamReader(
						                whatismyip.openStream()));

						ip = in.readLine(); //you get the IP as a String
						System.out.println("IP "+ip);
						}
						catch(Exception e)
						{
							
						}
					System.out.println(studentip);
					ipaddress=ipaddress+"/"+ip;
					
					int i=0,j=0;
					for(i=0;i<studentip.length();i++)
					{
						if(studentip.charAt(i)!='/')
						{
							ips1[j]=ips1[j]+studentip.charAt(i);
							j--;
						}
						j++;
					}
					
					i=0;
					j=0;
					for(i=0;i<ipaddress.length();i++)
					{
						if(ipaddress.charAt(i)!='/')
						{
							ips2[j]=ips2[j]+ipaddress.charAt(i);
							j--;
						}
						j++;
					}
					
					System.out.println("Student part1: "+ips1[0]+" part2: "+ips1[1]+" part3: "+ips1[2]);
					System.out.println("Parent part1: "+ips2[0]+" part2: "+ips2[1]+" part3: "+ips2[2]);
					
					if(ips1[0].equals(ips2[0]) || ips1[1].equals(ips2[1]) || ips1[2].equals(ips2[2])){
						gatepass.setStatus("IP Conflict");
					}
					else{
						gatepass.setStatus("Parent Approved");
						
					}
					
					gatepass.setParentIp(ipaddress);
					gatepass.setParentApprovedtime(resultdate);
					service.addgatepass(gatepass);
					grid.getDataProvider().refreshAll();
					window.close();
				}
				
	        	
	        });
	        
	        root.addComponent(accept);
	        
	        
	        Button reject = new Button("Reject");
	        reject.setWidth("70px");
	        reject.setStyleName("red-button-style");
	        reject.addClickListener(new Button.ClickListener() {

				
				@Override
				public void buttonClick(ClickEvent event) {
//					try {
//						InetAddress ip = InetAddress.getLocalHost();
//						ipaddress = ip.toString();
//						root.addComponent(new Label(ipaddress));
//					} catch (UnknownHostException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					studentip = gatepass.getStudentIp();
//					
//					
//					
//					if(studentip.equals(ipaddress)){
//						gatepass.setStatus("IP Conflict");
//					}
////					else{
//						
//					}
//					gatepass.setParentIp(ipaddress);
					
					gatepass.setStatus("Parent Rejected");
					service.addgatepass(gatepass);
					grid.getDataProvider().refreshAll();
					window.close();
					
				}
	        	
	        });
	        
	        main.addComponent(tf1);
	        main.addComponent(statusF);
	        main.setComponentAlignment(tf1, Alignment.TOP_CENTER);
	        main.setComponentAlignment(statusF, Alignment.TOP_CENTER);
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
	       
			
			window.setContent(root);
			return window;
		}
	}
	
	public Component createComponent(GatepassTable gatepass,Grid<GatepassTable> grid)
	{
		return new MarkWindowHandler().inti().layout(gatepass,grid);
	}

}	