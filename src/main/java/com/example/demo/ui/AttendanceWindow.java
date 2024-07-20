package com.example.demo.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Attendance;
import com.example.demo.entities.Cours;
import com.example.demo.entities.Mark;
import com.example.demo.service.StudentService;
import com.example.demo.ui.MarkWindow.MarkWindowHandler;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@org.springframework.stereotype.Component
public class AttendanceWindow {
	
	@Autowired
	StudentService studentService;
	
	int tot,pre,abs;
	float pert;
	
	public class AttendanceWindowHandler
	{
		public AttendanceWindowHandler inti()
		{
			return this;
		}
		public Component layout(String id,Cours c)
		{
			Window windows=new Window();
			windows.setSizeFull();
//			windows.addStyleName("viewwindow");
			windows.setHeight("50%");
			windows.setWidth("50%");
			windows.setCaption(c.getCourseName());
			windows.center();
			windows.setModal(true);
			VerticalLayout layout2=new VerticalLayout();
			layout2.setSizeFull();
			
			
			HorizontalLayout hlay=new HorizontalLayout();
			hlay.setWidth("80%");
			
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
			
			Label plabel=new Label();
			plabel.setCaption("Present");
			plabel.setValue(String.valueOf(pre));
			
			Label alabel=new Label();
			alabel.setCaption("Absent");
			alabel.setValue(String.valueOf(abs));
			
			Label tlabel=new Label();
			tlabel.setCaption("Total");
			tlabel.setValue(String.valueOf(tot));
			
			Label pelabel=new Label();
			pelabel.setCaption("Percentage");
			pelabel.setValue(String.valueOf(pert));
			
			hlay.addComponents(tlabel,plabel,alabel,pelabel);
//			hlay.setComponentAlignment(pelabel, Alignment.MIDDLE_RIGHT);
//			hlay.setComponentAlignment(tlabel, Alignment.MIDDLE_LEFT);
//			hlay.setComponentAlignment(plabel, Alignment.MIDDLE_CENTER);
//			hlay.setComponentAlignment(alabel, Alignment.MIDDLE_CENTER);
			
			
			layout2.addComponent(hlay);
			
			Grid<Attendance> att=new Grid<>(Attendance.class);
			att.setItems(studentService.getAttendanceByCourse(id, c));
			att.setWidth("50%");
			att.setHeight("50%");
			att.setHeight("100%");
			att.removeAllColumns();
			att.addColumn("course");
			att.addColumn("attDate").setCaption("Date");
			att.addColumn("status");
			att.sort("attDate", SortDirection.DESCENDING);
			layout2.addComponent(att);
			layout2.setComponentAlignment(att,Alignment.TOP_CENTER);
			layout2.setComponentAlignment(hlay,Alignment.MIDDLE_CENTER);
			windows.setContent(layout2);
			return windows;
		}
	}
	
	public Component createComponent(String id,Cours c)
	{
		return new AttendanceWindowHandler().inti().layout(id,c);
	}

}
