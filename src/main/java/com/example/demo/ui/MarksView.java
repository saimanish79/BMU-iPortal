package com.example.demo.ui;

import javax.swing.GroupLayout.Alignment;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.Mark;
import com.example.demo.service.StudentService;
import com.example.demo.ui.AttendanceView.AttendanceHandler;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@org.springframework.stereotype.Component
public class MarksView {
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	MarkWindow markWindow;
	
	
	public class MarkHandler
	{
		public MarkHandler init()
		{
			return this;
		}
		
		public Component layout(String id)
		{
			HorizontalLayout layout=new HorizontalLayout();
			//layout.setSizeFull();
			layout.setHeight("100%");
			layout.setWidth("100%");
			
			
			//Label l=new Label("HI hello");
			Grid<Mark> mar=new Grid<>(Mark.class);
			//mar.setSizeFull();
			mar.setHeight("100%");
			mar.setWidth("50%");
			mar.setItems(studentService.getMarks(id));
			mar.removeAllColumns();
			mar.addColumn("sem").setCaption("Semester");
			mar.addColumn("gpa").setCaption("GPA");
//			mar.addColumn("c1").setCaption("Subject");
//			mar.addColumn("marks1").setCaption("Marks");
//			mar.addColumn("c2").setCaption("Subject");
//			mar.addColumn("marks2").setCaption("Marks");
//			mar.addColumn("c3").setCaption("Subject");
//			mar.addColumn("marks3").setCaption("Marks");
//			mar.addColumn("c4").setCaption("Subject");
//			mar.addColumn("marks4").setCaption("Marks");
//			mar.addColumn("c5").setCaption("Subject");
//			mar.addColumn("marks5").setCaption("Marks");
//			mar.addColumn("c6").setCaption("Subject");
//			mar.addColumn("marks6").setCaption("Marks");
//			mar.addColumn("c7").setCaption("Subject");
//			mar.addColumn("marks7").setCaption("Marks");
			mar.sort("sem", SortDirection.DESCENDING);
			
			
			Panel panel=new Panel();
			panel.setWidth("70%");
			panel.setVisible(false);
			
			VerticalLayout root=new VerticalLayout();
			//root.setSizeFull();
			//root.setMargin(true);
			root.setHeight("100%");
			root.setWidth("100%");
			
			
			
	        HorizontalLayout horizontalLayout=new HorizontalLayout();
	        horizontalLayout.setSizeFull();
	        root.addComponent(horizontalLayout);
			root.setComponentAlignment(horizontalLayout, com.vaadin.ui.Alignment.MIDDLE_CENTER);
			
			
			
			Label l2=new Label();
	        root.addComponent(l2);
	        root.setComponentAlignment(l2, com.vaadin.ui.Alignment.BOTTOM_CENTER);
	        
	        Label l1= new Label();
	        root.addComponent(l1);
	        root.setComponentAlignment(l1, com.vaadin.ui.Alignment.BOTTOM_CENTER);
			
			
			
			VerticalLayout verticalLayout1=new VerticalLayout();
			verticalLayout1.setWidth("10%");
			horizontalLayout.addComponent(verticalLayout1);
			horizontalLayout.setComponentAlignment(verticalLayout1, com.vaadin.ui.Alignment.MIDDLE_LEFT);
			
			
			VerticalLayout verticalLayout2=new VerticalLayout();
			verticalLayout2.setWidth("40%");
			horizontalLayout.addComponent(verticalLayout2);
			horizontalLayout.setComponentAlignment(verticalLayout2, com.vaadin.ui.Alignment.MIDDLE_RIGHT);

			
			
			
			Label l3=new Label();
	        verticalLayout1.addComponent(l3);
	       
	        
	        
	        Label l4=new Label();
	        verticalLayout1.addComponent(l4);
	        
	        
	        
	        Label l5=new Label();
	        verticalLayout1.addComponent(l5);
	        
	        
	        Label l6=new Label();
	        verticalLayout2.addComponent(l6);
	        
	        
	        Label l7=new Label();
	        verticalLayout2.addComponent(l7);
	        
	        
	        Label l8=new Label();
	        verticalLayout2.addComponent(l8);
	        
			
			
			mar.asSingleSelect().addValueChangeListener(event ->{
				if(event.getValue()!=null)
				{
					//UI.getCurrent().addWindow((Window) markWindow.createComponent(event.getValue()));
					
					Mark mark=event.getValue();
					
					double tot = (mark.getMarks1().doubleValue()*mark.getSection().getCours1().getCredits().doubleValue())
							+(mark.getMarks2().doubleValue()*mark.getSection().getCours2().getCredits().doubleValue())
							+(mark.getMarks3().doubleValue()*mark.getSection().getCours3().getCredits().doubleValue())
							+(mark.getMarks4().doubleValue()*mark.getSection().getCours4().getCredits().doubleValue())
							+(mark.getMarks5().doubleValue()*mark.getSection().getCours5().getCredits().doubleValue())
							+(mark.getMarks6().doubleValue()*mark.getSection().getCours6().getCredits().doubleValue())
							+(mark.getMarks7().doubleValue()*mark.getSection().getCours7().getCredits().doubleValue());
					double totc=mark.getSection().getCours1().getCredits().doubleValue()
							+mark.getSection().getCours2().getCredits().doubleValue()
							+mark.getSection().getCours3().getCredits().doubleValue()
							+mark.getSection().getCours4().getCredits().doubleValue()
							+mark.getSection().getCours5().getCredits().doubleValue()
							+mark.getSection().getCours6().getCredits().doubleValue()
							+mark.getSection().getCours7().getCredits().doubleValue();
					
					
					
					//System.out.println(mark.getC1()+"   "+mark.getSection().getCours1().getCourseName());
					
					l1.setCaption("SGPA");
					l1.setValue(String.valueOf(tot/totc));
					
					panel.setCaption("Semester "+mark.getSem());
					panel.setVisible(true);
					l2.setCaption(mark.getC1());
					l2.setValue(String.valueOf(mark.getMarks1()));
					
					l3.setCaption(mark.getC2());
					l3.setValue(String.valueOf(mark.getMarks2()));
					
					l4.setCaption(mark.getC3());
					l4.setValue(String.valueOf(mark.getMarks3()));
					
					l5.setCaption(mark.getC4());
					l5.setValue(String.valueOf(mark.getMarks4()));
					
					l6.setCaption(mark.getC5());
					l6.setValue(String.valueOf(mark.getMarks5()));
					
					l7.setCaption(mark.getC6());
					l7.setValue(String.valueOf(mark.getMarks6()));
					
					l8.setCaption(mark.getC7());
					l8.setValue(String.valueOf(mark.getMarks7()));
				}
				
			});
			
			panel.setContent(root);
			layout.addComponents(mar,panel);
			
			layout.setComponentAlignment(mar, com.vaadin.ui.Alignment.MIDDLE_CENTER);
			layout.setComponentAlignment(panel, com.vaadin.ui.Alignment.MIDDLE_CENTER);
			return layout;
		}
	}
	
	public Component createComponent(String id){
		return new MarkHandler().init().layout(id);
	}

}
