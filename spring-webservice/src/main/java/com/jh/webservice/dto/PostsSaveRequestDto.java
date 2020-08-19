package com.jh.webservice.dto;

import com.jh.webservice.domain.posts.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

//controller에서 @RequestBody로 외부에서 데이터를 받은 경우네는 기본생성가 + set메소드를 통해서만 값이 할당이 됨.

@NoArgsConstructor


//Request와 Response용 DTO임. (view를 위한 클래스라 자주 변경됨.)

public class PostsSaveRequestDto {
	
	private String title;
	private String content;
	private String author;
	
	@Builder
	public PostsSaveRequestDto(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
	
	public Posts toEntity() {
		return Posts.builder()
				.title(title)
				.content(content)
				.author(author)
				.build();
	}

	
}
