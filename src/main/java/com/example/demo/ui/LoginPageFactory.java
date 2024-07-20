package com.example.demo.ui;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;


import com.vaadin.server.ThemeResource;
import com.example.demo.entities.User;
import com.example.demo.entities.UserRole;
import com.example.demo.repositories.UserRepository;
import com.example.demo.repositories.UserRoleRepository;
import com.vaadin.server.Sizeable.Unit;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class LoginPageFactory {
	@Autowired
	private DaoAuthenticationProvider daoAuthenticationProvider;
//	@Autowired
//	private MainPageFactory main;
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	MainUI main;
	
	String Username=null;
	private class LoginForm {
		
		
		private VerticalLayout layout ;
	     TextField username;
	     Button login_button;
	     PasswordField password;
	     CssLayout buttons;
	     VerticalLayout centeringLayout;
	     CssLayout loginInformation;
	     ThemeResource logoResourse1;
	     Image logo1;
	     Label loginInfoText ;
//	     String firstname=null;
//	     String lastname=null;
//			String userid=null;
//			byte[] photo=null;
//			String userrole=null;
//			String passwords=null;
//			Date dob=null;
//			String mailid=null;
//			String sex=null;
		
		public LoginForm init() {
			
			layout=new VerticalLayout();
	        layout.setStyleName("login");
	      
	            username=new TextField("Username");
	            password=new PasswordField("Password");
	            username.setWidth(17, Unit.EM);
	            password.setWidth(17, Unit.EM);
	           login_button=new Button("LOGIN");
	            login_button.setStyleName("friendly");
	            buttons = new CssLayout();
	            buttons.setStyleName("buttons");
	        
	            loginInformation = new CssLayout();
	           logoResourse1= new ThemeResource("../../themes/mytheme/images/mBPM.png");
	            logo1= new Image("", logoResourse1);
	            logo1.setStyleName("image");
	            logo1.setWidth("218px");
	           
	            loginInformation.setStyleName("login-information");
	           loginInfoText = new Label("",
	                    ContentMode.HTML);
	           
	            loginInformation.addComponents(logo1,loginInfoText);
	            layout.addComponent(loginInformation);
	            
	            return this;
		}
		
		public Component layout() {
			
			FormLayout login=new FormLayout();
            login.addStyleName("login-form");
            login.setWidth("400px");
            login.setHeight("200px");
            login.setMargin(false);
            login.addComponent(buttons);

            login.addComponents(username,password,login_button);
            
            centeringLayout= new VerticalLayout();
            centeringLayout.setStyleName("centering-layout");
            centeringLayout.addComponents(login);
            centeringLayout.setComponentAlignment(login,
                    Alignment.MIDDLE_CENTER);
			login_button.addClickListener(new ClickListener() {
				public void buttonClick(ClickEvent event) {
					
					try {
						Authentication auth = new UsernamePasswordAuthenticationToken(username.getValue(), password.getValue());
						Authentication authenticated = daoAuthenticationProvider.authenticate(auth);
						SecurityContextHolder.getContext().setAuthentication(authenticated);
						Username=auth.getName();
						User user=	userRepository.findByUserId(Username);
						
//						//Takes roles of the users
//						List<UserRole> userRole = userRoleRepository.findByUser(user);
//						Collection<GrantedAuthority> authorities = new ArrayList<>();
//						for(UserRole role : userRole){
//							authorities.add(new SimpleGrantedAuthority(role.getRole().getRoleName()));
//						}
//
//						String authority = authorities.toString();
//						
//						//Authenticating users
//						if(authority.contains("STUDENT")){
//							UI.getCurrent().getPage().setLocation("/posts/list");;
//						}
//
//						if(authority.contains("PARENT")){
//							UI.getCurrent().getPage().setLocation("/posts/add");
//						}
						
						UI.getCurrent().setContent(main.createComponent(user.getUserId()));
					} catch (AuthenticationException e) {
						Notification.show("Error!", "Login fail! Try again", Type.ERROR_MESSAGE);
						System.out.println(e.getMessage());
					}
					
					username.clear();
					password.clear();
				}
			});
			
			 layout.addComponent(centeringLayout);
	            layout.setComponentAlignment(centeringLayout, Alignment.MIDDLE_CENTER);

	            return layout;
			
			
		}
	}
	
	public Component createComponent() {
		return new LoginForm().init().layout();
	}
}

