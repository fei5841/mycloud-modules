package com.liuchunshu.mycloud.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.liuchunshu.mycloud.service.MycloudFeignService;

@RestController
public class MycloudFeignController {

	@Autowired
	private MycloudFeignService service;
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(String name) {
		return service.index(name);
	}
	
	@RequestMapping(value="/hello1",method=RequestMethod.GET)
	public String hello1(String name,String password) {
		return service.index1(name,password);
	}
	
	@RequestMapping(value="/hello2",method=RequestMethod.GET)
	public String hello2(String name,String password) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", name);
		map.put("password", password);
		return service.index2(map);
	}
	
	@RequestMapping(value="/hello3",method=RequestMethod.GET)
	public String hello3(String name,String password) {
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name", name);
		map.put("password", password);
		return service.index3(map,"测试参数");
	}
}
