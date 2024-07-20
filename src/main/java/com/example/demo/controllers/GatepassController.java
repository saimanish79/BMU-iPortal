package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Student;

import com.example.demo.entities.GatepassTable;
import com.example.demo.service.GatepassService;



@RestController
public class GatepassController {
	@Autowired
	private GatepassService service;
	
	@RequestMapping("/gatepass/{id}")
	public List<GatepassTable> getallgatepasses(@PathVariable String id){
		return service.getallgatepassesbyId(id);
		}
	@RequestMapping("/gatepass")
	public Iterable<GatepassTable> getgatepass(){
		return service.getallgatepasses();
	}
	@RequestMapping(value="/gatepass/add",method=RequestMethod.POST)
	public void addgatepass(@RequestBody GatepassTable gatepass){
		service.addgatepass(gatepass);
	}
	
	
}
