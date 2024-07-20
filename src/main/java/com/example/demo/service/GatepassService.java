package com.example.demo.service;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entities.GatepassTable;
import com.example.demo.entities.User;
import com.example.demo.repositories.GatepassRepository;

@Service
public class GatepassService {
	@Autowired
	private GatepassRepository gatepassRepository;
	public List<GatepassTable> getallgatepassesbyId(String student_id){
		User user = new User();
		user.setUserId(student_id);
		List <GatepassTable> gatepass = new ArrayList<>();
		gatepassRepository.findByUser2(user).forEach(gatepass::add);
		return gatepass;
		
	}
	public void addgatepass(GatepassTable gatepass){
		gatepassRepository.save(gatepass);
	}
	public List<GatepassTable> getallgatepasses(){
		return (List<GatepassTable>) gatepassRepository.findAll();
	}
	public List<GatepassTable> getallGatepassByStatus() {
		
		return (List<GatepassTable>) gatepassRepository.findByStatus("");
	}
	
	
	public List<GatepassTable> getallGatepassByMultipleStatus() {
		
		return (List<GatepassTable>) gatepassRepository.findByStatusOrStatus("Parent Approved", "IP Conflict");
	}
	
	public GatepassTable findOneGatepass(Long gatepassId){
		return gatepassRepository.findOne(gatepassId);
	}
		
	
//	public List<GatepassTable> getParentGatepasses(String student_id){
//		
//		
//	}
	
	

}