package com.jh.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jh.webservice.domain.posts.PostsRepository;
import com.jh.webservice.dto.PostsMainResponseDto;
import com.jh.webservice.dto.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	
	private PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
	
	@Transactional(readOnly = true)
	//(readOnly = true) 라면 조회 기능만 남겨두고 나머ㅣ 기능은 작동안됨. 조회기능만 있는 메소드에서 사용하면 조회속도가 개선됨.
	public List<PostsMainResponseDto> findAllDesc(){
		//repository 결과로 넘어온  Posts의  Stream을 map을 통해 PostsMainResponseDto로 변환 -> List로 반환하는 메소드임.
		return postsRepository.findAllDesc()
				.map(PostsMainResponseDto::new) //람다식코드이다.
				.collect(Collectors.toList());
		//.map(PostsMainResponseDto::new) =  .map(posts -> new PostsMainResponseDto(posts)) 와 같은 의미.
	}
}
