package com.jh.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jh.webservice.domain.PostsRepository;
import com.jh.webservice.dto.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@RestController
//@RestContcoller => @ResponseBody를 모든 메소드에 적용해주는 어노테이션임
//@ResponseBody => 문자열을 JSON 형태로 반환해줌.
@AllArgsConstructor
//autowire대신 생성자로  bean객체를 받도록 하는것임. 모든필드를 인자값으로 하는 생성자를 생성해줌.

public class WebRestController {
	
	private PostsRepository postsRepository;
	
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
	public void savePosts(@RequestBody PostsSaveRequestDto dto) {
		postsRepository.save(dto.toEntity());
	}
}
