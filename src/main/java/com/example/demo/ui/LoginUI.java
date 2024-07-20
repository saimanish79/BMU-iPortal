package com.example.demo.ui;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Attendance;
import com.example.demo.entities.Mark;
import com.example.demo.service.StudentService;
import com.sun.xml.bind.v2.runtime.unmarshaller.Receiver;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.DateField;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;


@SpringUI(path=LoginUI.PATH)
@Theme("mytheme")
public class LoginUI extends UI{
	
	public static final String PATH = "/login";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	MainUI main;
	
	@Autowired
	LoginPageFactory login;

	@Override
	protected void init(VaadinRequest request) {
		// TODO Auto-generated method stub
		

		setContent(login.createComponent());
	}

}
