package com.liuchunshu.mycloud.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class MycloudRibbonService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${service.name}")
	private String serviceName;
	
	@HystrixCommand(fallbackMethod="hiError",defaultFallback="hiError1")
	public String helloService(String name) {
		return restTemplate.getForObject("http://"+serviceName+"/index1?name="+name, String.class);
	}
	
	//name={1}&password={12}中的1和12是虚拟的，不代表实际名称，算是占位符类型
	public String helloService1(String name,String password) {
		return restTemplate.getForObject("http://"+serviceName+"/index2?name={1}&password={12}", String.class,name,password);
	}
	
	public String helloService3(String name,String password) {
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", name);
		map.put("password", password);
		HttpEntity<Map<String, String>> entity=new HttpEntity<Map<String,String>>(map);
		return restTemplate.postForObject("http://"+serviceName+"/index3/{1}",entity, String.class,"测试参数");
	}

	@SuppressWarnings("unused")
	private String hiError(String name) {
		return "hi "+name+",Error!";
	}
	
	@SuppressWarnings("unused")
	private String hiError1() {
		return "it is default error!";
	}
}
