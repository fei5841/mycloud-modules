package com.liuchunshu.mycloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.liuchunshu.mycloud.service.MycloudRibbonService;

@RestController
public class MycloudRibbonController {

	@Autowired
	MycloudRibbonService service;
	
	@RequestMapping(value="/sayhi",method=RequestMethod.GET)
	public String sayHello(String name) {
		return service.helloService(name);
	}
	
	@RequestMapping(value="/sayhi1",method=RequestMethod.GET)
	public String sayHello1(String name,String password) {
		return service.helloService1(name,password);
	}
	
	@RequestMapping(value="/sayhi2",method=RequestMethod.GET)
	public String sayHello2(String name,String password) {
		return service.helloService3(name,password);
	}
}
