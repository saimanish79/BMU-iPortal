package com.example.demo.ui;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.example.demo.design.MainPage;
import com.example.demo.entities.User;
import com.example.demo.entities.UserRole;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.UserRoleRepository;
import com.example.demo.service.StudentService;
import com.vaadin.server.Responsive;
import com.vaadin.server.VaadinSession;
import com.vaadin.ui.Component;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class MainUI extends MainPage{
	
	@Autowired
	StudentView studentView;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ParentView parentView;
	
	@Autowired
	WardenView wardenView;
	
	@Autowired
	GatepassView gatepassView;
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	@Autowired
	SecurityView securityView;
	
	@Autowired
	StudentService studentService;
	
	String id1;
	
	
	private class MainPage
	{
		VerticalLayout Content=content;
		public  MainPage init(String id)
		{
			Content.setStyleName("content");
			Content.setSizeFull();
			Responsive.makeResponsive(menuItems);
			setResponsive(true);
			menuToggle.addClickListener(e->{
				 Responsive.makeResponsive(menuItems);
			});

			menuItems.addStyleName("sidebar");
			menuItems.addStyleName(ValoTheme.MENU_PART);
	        menuItems.addStyleName("no-vertical-drag-hints");
	      
	        menuItems.addStyleName("no-horizontal-drag-hints");
	        menuItems.setWidth(null);
	        menuItems.setHeight("90%");
	        content.setStyleName("content");
			student.setStyleName("menu1");
			gatepass.setStyleName("menu1");
			logout.setStyleName("menu1");
		
			content.removeAllComponents();
			mainpagevl.setStyleName("mainpagevl");
			mainpagevl.setWidth("1300px");
			
			User user=userRepository.findByUserId(id);
			//Takes roles of the users
			List<UserRole> userRole=userRoleRepository.findByUser(user);
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			
			for(UserRole role : userRole){
				authorities.add(new SimpleGrantedAuthority(role.getRole().getRoleName()));
			}
			String authority = authorities.toString();
			if(authority.contains("PARENT")){
				student.setVisible(true);
			}
			
			if(authority.contains("WARDEN")){
				student.setVisible(false);
			}
			
			if(authority.contains("STUDENT")){
				student.setVisible(true);
			}
			
			if(authority.contains("SECURITY")){
				student.setVisible(false);
			}
			return this;
		}
		
		public Component layout(String id)
		{
			id1=id;
			User user=userRepository.findByUserId(id);
			//Takes roles of the users
			List<UserRole> userRole = userRoleRepository.findByUser(user);
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			for(UserRole role : userRole){
				authorities.add(new SimpleGrantedAuthority(role.getRole().getRoleName()));
			}
			String authority = authorities.toString();
			
			if(authority.contains("PARENT")){
				id1=studentService.getStudentByParent(user).getStudentId();
			}
			
			if(authority.contains("WARDEN")){
				content.addComponent(wardenView.createComponent(user));
			}
			
			else if(authority.contains("SECURITY")){
				content.addComponent(securityView.createComponent(user));
			}else{
			content.addComponent(studentView.createComponent(id1));
			}
			
			student.addClickListener(e->{
				content.removeAllComponents();
				content.addComponent(studentView.createComponent(id1));
				System.out.println("ID: "+id);
				
			});
			
			logout.addClickListener(e->{
				for (UI ui: VaadinSession.getCurrent().getUIs())
		              ui.access(() -> {
		                  ui.getPage().setLocation("/login/");
		                  
		              });
				
			});
			
			gatepass.addClickListener(e->{
				
				
				content.removeAllComponents();
				
				
				//Authenticating users
				if(authority.contains("STUDENT")){
					content.addComponent(gatepassView.createComponent(user));
				}

				if(authority.contains("PARENT")){
					content.addComponent(parentView.createComponent(user));
				}
				
				if(authority.contains("WARDEN")){
					content.addComponent(wardenView.createComponent(user));
				}
				
				if(authority.contains("SECURITY")){
					content.addComponent(securityView.createComponent(user));
				}
				
				
				//content.addComponent(parentView.createComponent(user));
				//content.addComponent(gatepassView.createComponent(user));
				//content.addComponent(wardenView.createComponent(user));
	    	  
			});
			return mainlayout;
		}
		
	}
	
	public Component createComponent(String id)
	{
		return new MainPage().init(id).layout(id);
	}

}
