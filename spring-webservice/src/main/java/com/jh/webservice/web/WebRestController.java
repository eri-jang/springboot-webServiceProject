package com.jh.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RestContcoller => @ResponseBody를 모든 메소드에 적용해주는 어노테이션임
//@ResponseBody => 문자열을 JSON 형태로 반환해줌.
public class WebRestController {
	
	@GetMapping("/hello")
	public String hello() {
		return "Helloworld";
	}
}
