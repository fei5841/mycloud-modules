package com.liuchunshu.mycloud.service.hystrix;

import java.util.Map;

import org.springframework.stereotype.Component;

import com.liuchunshu.mycloud.service.MycloudFeignService;

@Component
public class MycloudFeignServiceImpl implements MycloudFeignService{

	@Override
	public String index(String name) {
		return "sorry,"+name+",feign index error!";
	}

	@Override
	public String index1(String name, String password) {
		return "sorry,"+name+":"+password+",feign index1 error!";
	}

	@Override
	public String index2(Map<String, Object> map) {
		return "sorry,"+map.get("name")+":"+map.get("password")+",feign index2 error!";
	}

	@Override
	public String index3(Map<String, Object> map, String str) {
		return "sorry,"+map.get("name")+":"+map.get("password")+",feign index3 error!"+str;
	}

}
