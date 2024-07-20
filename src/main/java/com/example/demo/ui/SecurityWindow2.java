package com.example.demo.ui;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.GatepassTable;
import com.example.demo.entities.Mark;
import com.example.demo.entities.User;
import com.example.demo.service.GatepassService;
import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@org.springframework.stereotype.Component
public class SecurityWindow2 {
	
	@Autowired
	GatepassService service;
	
	ThemeResource logoResourse1;
    Image logo1;
	
	public class MarkWindowHandler
	{
		public MarkWindowHandler inti()
		{
			return this;
		}
		
		public Component layout()
		{
			Window window = new Window();
			window.setHeight("80%");
			window.setWidth("60%");
			window.center();
			VerticalLayout root=new VerticalLayout();
			root.setSizeFull();
			root.setMargin(true);
			root.setHeight("100%");
			
			logoResourse1= new ThemeResource("../../themes/mytheme/images/reject.jpg");
            logo1= new Image("", logoResourse1);
            
            logo1.setStyleName("image");
            logo1.setWidth("300px");	
            
            
			
	       
			root.addComponent(logo1);
			
			root.setComponentAlignment(logo1, Alignment.TOP_CENTER);
			window.setContent(root);
			return window;
		}
	}
	
	public Component createComponent()
	{
		return new MarkWindowHandler().inti().layout();
	}

}
