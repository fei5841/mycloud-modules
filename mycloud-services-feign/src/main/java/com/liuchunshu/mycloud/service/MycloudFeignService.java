package com.liuchunshu.mycloud.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="mycloud-services")
public interface MycloudFeignService {

	@RequestMapping(value="/index1",method=RequestMethod.GET)
	public String index(@RequestParam("name") String name);
	
	//get请求多参数，方法1
	@GetMapping(value="/index2")
	public String index1(@RequestParam("name") String name,@RequestParam("password") String password);
	
	//get请求多参数，方法2
	@GetMapping(value="/index2")
	public String index2(@RequestParam Map<String ,Object> map);
	
	//post请求多参数
	@PostMapping(value="/index3/{string}")
	public String index3(@RequestBody Map<String ,Object> map,@RequestParam("string") String str);
}
