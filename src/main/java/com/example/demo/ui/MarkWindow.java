package com.example.demo.ui;

import com.example.demo.entities.Mark;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@org.springframework.stereotype.Component
public class MarkWindow {
	
	public class MarkWindowHandler
	{
		public MarkWindowHandler inti()
		{
			return this;
		}
		
		public Component layout(Mark mark)
		{
			Window window = new Window();
			//window.addStyleName("newapptype");
			window.setHeight("80%");
			window.setWidth("30%");
			window.center();
			window.setCaption("Semester  "+mark.getSem());
			VerticalLayout root=new VerticalLayout();
			root.setSizeFull();
			root.setMargin(true);
			root.setHeight("100%");
			
			
			/*TextField tf1=new TextField();
			tf1.setCaption("Semester");
			tf1.setValue(mark.getSem());
			tf1.setReadOnly(true);*/
			
			
//			Label l1=new Label();
//			l1.setCaption("Semester");
//			l1.setValue(mark.getSem());
//	        root.addComponent(l1);
//	        root.setComponentAlignment(l1, Alignment.TOP_CENTER);
			
			
	        HorizontalLayout horizontalLayout=new HorizontalLayout();
	        root.addComponent(horizontalLayout);
	        root.setSizeFull();
			root.setMargin(true);
			root.setHeight("100%");
			root.setComponentAlignment(horizontalLayout, Alignment.MIDDLE_CENTER);
			
			
			/*TextField tf2=new TextField();
			tf2.setCaption(mark.getC1());
			tf2.setValue(String.valueOf(mark.getMarks1()));
			tf2.setReadOnly(true);
			root.addComponent(tf2);
			root.setComponentAlignment(tf2, Alignment.BOTTOM_CENTER);*/
			
			
			Label l2=new Label();
			l2.setCaption(mark.getC1());
			l2.setValue(String.valueOf(mark.getMarks1()));
	        root.addComponent(l2);
	        root.setComponentAlignment(l2, Alignment.BOTTOM_CENTER);
			
			
			
			VerticalLayout verticalLayout1=new VerticalLayout();
			horizontalLayout.addComponent(verticalLayout1);
			
			
			VerticalLayout verticalLayout2=new VerticalLayout();
			horizontalLayout.addComponent(verticalLayout2);
			
			
			/*TextField tf3=new TextField("tf3");
			tf3.setCaption(mark.getC2());
			tf3.setValue(String.valueOf(mark.getMarks2()));
			tf3.setReadOnly(true);
			verticalLayout1.addComponent(tf3);*/
			
			
			Label l3=new Label();
			l3.setCaption(mark.getC2());
			l3.setValue(String.valueOf(mark.getMarks2()));
	       verticalLayout1.addComponent(l3);
	        
			
			/*TextField tf4=new TextField("tf4");
			tf4.setCaption(mark.getC3());
			tf4.setValue(String.valueOf(mark.getMarks3()));
			tf4.setReadOnly(true);
			verticalLayout1.addComponent(tf4);*/
	        
	        
	        Label l4=new Label();
			l4.setCaption(mark.getC3());
			l4.setValue(String.valueOf(mark.getMarks3()));
	        verticalLayout1.addComponent(l4);
	        
			
			/*TextField tf5=new TextField("tf5");
			tf5.setCaption(mark.getC4());
			tf5.setValue(String.valueOf(mark.getMarks4()));
			tf5.setReadOnly(true);
			verticalLayout1.addComponent(tf5);*/
	        
	        
	        Label l5=new Label();
			l5.setCaption(mark.getC4());
			l5.setValue(String.valueOf(mark.getMarks4()));
	        verticalLayout1.addComponent(l5);
	       
			
		/*	TextField tf6=new TextField("tf6");
			tf6.setCaption(mark.getC5());
			tf6.setValue(String.valueOf(mark.getMarks5()));
			tf6.setReadOnly(true);
			verticalLayout2.addComponent(tf6);*/
	        
	        
	        Label l6=new Label();
			l6.setCaption(mark.getC5());
			l6.setValue(String.valueOf(mark.getMarks5()));
	        verticalLayout2.addComponent(l6);
	       
			
			/*TextField tf7=new TextField("tf7");
			tf7.setCaption(mark.getC6());
			tf7.setValue(String.valueOf(mark.getMarks6()));
			tf7.setReadOnly(true);
			verticalLayout2.addComponent(tf7);*/
	        
	        
	        Label l7=new Label();
			l7.setCaption(mark.getC6());
			l7.setValue(String.valueOf(mark.getMarks6()));
	       verticalLayout2.addComponent(l7);
	        
	        
	       /* TextField tf8=new TextField("tf8");
			tf8.setCaption(mark.getC7());
			tf8.setValue(String.valueOf(mark.getMarks7()));
			tf8.setReadOnly(true);
			verticalLayout2.addComponent(tf8);*/
	        
	        
	        Label l8=new Label();
			l8.setCaption(mark.getC7());
			l8.setValue(String.valueOf(mark.getMarks7()));
	        verticalLayout2.addComponent(l8);
			
			window.setContent(root);
			return window;
		}
	}
	
	public Component createComponent(Mark mark)
	{
		return new MarkWindowHandler().inti().layout(mark);
	}

}
