package com.example.demo.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TabSheet;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

@org.springframework.stereotype.Component
public class StudentView {
	
	private Label titleLabel;
	public static final String TITLE_ID = "dashboard-title";
	
	@Autowired
	DetailsView detailsView;
	
	@Autowired
	AttendanceView attendanceView;
	
	@Autowired
	MarksView marksView;

	private class StudentHandler{

		
		TabSheet studenthandler_tabsheet;
		VerticalLayout mainvl;
		

		public StudentHandler init(){
			studenthandler_tabsheet = new TabSheet();
			studenthandler_tabsheet.setStyleName(ValoTheme.TABSHEET_FRAMED);
		studenthandler_tabsheet.addStyleName(ValoTheme.TABSHEET_EQUAL_WIDTH_TABS);

	mainvl=new VerticalLayout();
	return this;
		}
		public Component layout(String id){
			
//			errorhandler_tabsheet.addTab(application.createComponent(), "Applications", FontAwesome.CUBE, 0);
//			errorhandler_tabsheet.addTab(project.createComponent(), "Flows", FontAwesome.DESKTOP, 1);
//			errorhandler_tabsheet.addTab(errors.createComponent(), "Errors", FontAwesome.CLOSE,2);
			studenthandler_tabsheet.addTab(detailsView.createComponent(id),"Details",FontAwesome.CUBE,0);
			studenthandler_tabsheet.addTab(attendanceView.createComponent(id),"Attendance",FontAwesome.CUBE,1);
			studenthandler_tabsheet.addTab(marksView.createComponent(id),"Marks",FontAwesome.CUBE,2);

	
//			errorhandler_tabsheet.getTab(0).setClosable(true);
//			errorhandler_tabsheet.getTab(1).setClosable(true);
//			errorhandler_tabsheet.getTab(2).setClosable(true);

		
		mainvl.setSizeFull();
		mainvl.setSpacing(false);
		mainvl.setMargin(false);
		mainvl.addComponents(buildHeaderr(),studenthandler_tabsheet);

		return mainvl;
		
		}
	}
	private Component buildHeaderr() {
		HorizontalLayout header = new HorizontalLayout();
        header.addStyleName("viewheader");
        header.setSpacing(true);

        titleLabel = new Label("Student Details");
        titleLabel.setId(TITLE_ID);
        titleLabel.setSizeUndefined();
        titleLabel.addStyleName(ValoTheme.LABEL_H1);
        titleLabel.addStyleName(ValoTheme.LABEL_NO_MARGIN);
        header.addComponent(titleLabel);
        return header;
	}
	public Component createComponent(String id){
		return new StudentHandler().init().layout(id);
	}

}
