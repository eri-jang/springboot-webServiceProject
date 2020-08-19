package com.jh.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jh.webservice.dto.PostsSaveRequestDto;
import com.jh.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@RestController

//@RestContcoller => @ResponseBody를 모든 메소드에 적용해주는 어노테이션임
//@ResponseBody => 문자열을 JSON 형태로 반환해줌.

@AllArgsConstructor


public class WebRestController {
	
	private PostsService postsService;
	
	/*
	 * @AllArgsConstructor 어노테이션이 아래와 같은 형태임.
	 * 사용하는 이유: 의존성관계가 변경될때마다 생성자 코드를 계속해서 수정해야하는 번거로움을 해결하기 위함이다,
	 * public public WebRestController(PostsRepository postsRepository) {
	 * this.postsRepository = postsRepository; }
	 */
	
	@GetMapping("/hello")
	public String hello() {
		return "Helloworld";
	}
	
	@PostMapping("/posts")
	public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
		return postsService.save(dto);
	}
}
