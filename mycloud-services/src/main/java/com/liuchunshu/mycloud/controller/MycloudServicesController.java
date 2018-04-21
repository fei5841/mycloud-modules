package com.liuchunshu.mycloud.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MycloudServicesController {

	@Value("${server.port}")
	private String port;
	
	@RequestMapping(value="/index1",method=RequestMethod.GET)
	public String index1(String name) {
	
		return "hello "+name+",i am from mycloud service.index1("+port+")!";
	}
	
	@RequestMapping(value="/index2",method=RequestMethod.GET)
	public String index2(String name,String password) {
	
		return "hello "+name+":"+password+",i am from mycloud service.index2("+port+")!";
	}
	
	//post接口接受多个参数时，前台传入的多个参数（或对象）都放在RequestBody中，所以需要通过@RequestBody注解接收参数（或对象）
	@RequestMapping(value="/index3/{str}",method=RequestMethod.POST)
	public String index3(@RequestBody Map<String, String> map,@PathVariable String str) {
	
		return "hello "+map.get("name")+":"+map.get("password")+",i am from mycloud service.index3("+port+")!"+str;
	}
}
