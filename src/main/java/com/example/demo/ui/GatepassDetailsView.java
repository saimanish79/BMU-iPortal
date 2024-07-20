package com.example.demo.ui;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entities.GatepassTable;
import com.example.demo.entities.User;
import com.example.demo.service.GatepassService;
//import com.example.demo.entities.Attendance;
//import com.example.demo.service.StudentService;
//import com.example.demo.ui.AttendanceView.AttendanceHandler;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
@org.springframework.stereotype.Component
public class GatepassDetailsView {
	
	@Autowired
	GatepassService service;
	
	public class gatepassHandler
	{
		
		
		public gatepassHandler init()
		{
			return this;
		}
		
		public Component layout(User currentUser)
		{
			String currentUserId = currentUser.getUserId();
			VerticalLayout layout2=new VerticalLayout();
			layout2.setSizeFull();
			Grid<GatepassTable> grid = new Grid<>(GatepassTable.class);
			
			grid.setWidth("1200px");
			grid.setItems(service.getallgatepassesbyId(currentUserId));
			grid.removeAllColumns();
			grid.addColumn("gatepassId").setCaption("Gatepass ID");
//			grid.addColumn("actualCheckintime").setCaption("CheckIn Time");
//			grid.addColumn("actualCheckouttime").setCaption("CheckOut Time");
			grid.addColumn("studentReason").setCaption("Reason");
			grid.addColumn("requestedCheckout").setCaption("Requested CheckOut Time");
			grid.addColumn("requestedCheckin").setCaption("Requested CheckIn Time");
			grid.addColumn("status");
			grid.addColumn("actualCheckintime").setCaption("Actual CheckIn Time");
			grid.addColumn("actualCheckouttime").setCaption("Actual CheckOut Time");
			
//			grid.addColumn("requestedCheckin").setCaption("Requested Checkin");
			grid.sort("gatepassId",SortDirection.DESCENDING);
			layout2.addComponent(grid);
			return layout2;
		}
		

}
	
public Component createComponent(User user){
	return new gatepassHandler().init().layout(user);
}
}

