package com.jh.webservice.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import com.jh.webservice.domain.posts.Posts;

import lombok.Getter;

@Getter
public class PostsMainResponseDto {
	private Long id;
	private String title;
	private String author;
	private String modifiedDate; //String으로 한 이유 : view영역에서는 LocalDateTime타입을 모르기 때문,
	
	public PostsMainResponseDto(Posts entity) {
		id = entity.getId();
		title = entity.getTitle();
		author = entity.getAuthor();
		modifiedDate = toStringDateTime(entity.getModifiedDate());
		
	}
	
	private String toStringDateTime(LocalDateTime localDateTime) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return Optional.ofNullable(localDateTime)
				.map(formatter::format)
				.orElse("");
		
	}
	//DTO는 Entity를 사용해도 되지만, Entity는  DTO에 대해 전혀 모르게 코드를 구성해야함.
	//즉, DTO가 Entity에 의존하도록 코드를 작성해야함.
}
