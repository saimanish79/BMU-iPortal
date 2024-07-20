package com.example.demo.ui;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Attendance;
import com.example.demo.entities.Cours;
import com.example.demo.service.StudentService;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@org.springframework.stereotype.Component
public class AttendanceView {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	AttendanceWindow attendanceWindow;
	
	int tot,pre,abs;
	float pert;
	
	public class AttendanceHandler
	{
		
		
		public AttendanceHandler init()
		{
			return this;
		}
		
		public Component layout(String id)
		{
			HorizontalLayout layout1=new HorizontalLayout();
			layout1.setSizeFull();
			layout1.setHeight("100%");
//			Grid<Attendance> att=new Grid<>(Attendance.class);
//			att.setItems(studentService.getAttendance(id));
//			att.setSizeFull();
//			att.setHeight("100%");
//			att.removeAllColumns();
//			att.addColumn("course");
//			att.addColumn("attDate").setCaption("Date");
//			att.addColumn("status");
//			att.sort("attDate", SortDirection.DESCENDING);
//			layout2.addComponent(att);
			
			Grid<Cours> att=new Grid<>(Cours.class);
			att.setItems(studentService.getSections(id));
			att.setSizeFull();
			att.setWidth("35%");
			att.setHeight("100%");
			att.removeAllColumns();
			att.addColumn("courseName");
			
			
			Panel panel = new Panel();
			panel.setWidth("80%");
			panel.setHeight("500px");
			panel.setVisible(false);
			//panel.setStyleName("blue-col");
			
			
			VerticalLayout layout2=new VerticalLayout();
			//layout2.setSizeFull();
			layout2.setHeight("400px");
			//layout2.setStyleName("blue-col");
			
			HorizontalLayout hlay=new HorizontalLayout();
			hlay.setWidth("100%");
			//hlay.setStyleName("white-col");
			
			
			
			Label plabel=new Label();
			
			
			Label alabel=new Label();
			
			
			Label tlabel=new Label();
			
			
			Label pelabel=new Label();
			//pelabel.setStyleName("blue-col");
			
			
			hlay.addComponents(tlabel,plabel,alabel,pelabel);
//			hlay.setComponentAlignment(pelabel, Alignment.MIDDLE_RIGHT);
//			hlay.setComponentAlignment(tlabel, Alignment.MIDDLE_LEFT);
//			hlay.setComponentAlignment(plabel, Alignment.MIDDLE_CENTER);
//			hlay.setComponentAlignment(alabel, Alignment.MIDDLE_CENTER);
			//hlay.setStyleName("blue-col");
			
			layout2.addComponent(hlay);
			Grid<Attendance> att2=new Grid<>(Attendance.class);
			
			
			att.asSingleSelect().addValueChangeListener(event ->{
				if(event.getValue()!=null)
				{
					//UI.getCurrent().addWindow((Window) attendanceWindow.createComponent(id,event.getValue()));
					
					Cours c=event.getValue();
					
					pre=studentService.getAttendanceByCourseAndStatus(id, c, "P").size();
					abs=studentService.getAttendanceByCourseAndStatus(id, c, "A").size();
					tot=pre+abs;
					try
					{
					pert=(float) ((100*pre)/tot);
					}
					catch(ArithmeticException e)
					{
						pert=0;
					}
					
					panel.setCaption(c.getCourseName());
					panel.setVisible(true);
					plabel.setCaption("Present");
					plabel.setValue(String.valueOf(pre));
					alabel.setCaption("Absent");
					alabel.setValue(String.valueOf(abs));
					tlabel.setCaption("Total");
					tlabel.setValue(String.valueOf(tot));
					pelabel.setCaption("Percentage");
					pelabel.setValue(String.valueOf(pert));
					
					att2.setItems(studentService.getAttendanceByCourse(id, c));
					att2.setWidth("100%");
					att2.setHeight("300px");
					att2.removeAllColumns();
					att2.addColumn("course");
					att2.addColumn("attDate").setCaption("Date");
					att2.addColumn("status");
					att2.sort("attDate", SortDirection.DESCENDING);
					layout2.addComponent(att2);
					layout2.setComponentAlignment(att2,Alignment.TOP_CENTER);
					layout2.setComponentAlignment(hlay,Alignment.MIDDLE_CENTER);
				}
				
			});
			
			panel.setContent(layout2);
			layout1.addComponents(att,panel);
			layout1.setComponentAlignment(att, Alignment.MIDDLE_CENTER);
			layout1.setComponentAlignment(panel, Alignment.MIDDLE_CENTER);
			return layout1;
		}
		
	}
	
	public Component createComponent(String id){
		return new AttendanceHandler().init().layout(id);
	}

}
