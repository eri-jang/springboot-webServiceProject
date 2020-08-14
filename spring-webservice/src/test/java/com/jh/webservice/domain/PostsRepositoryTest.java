package com.jh.webservice.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.After;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest

public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		
		/*
		 * 이후 테스트 코드에 영향을 끼치지 않기 위해 테스트 메소드가 끝날때 마다 repository 전체 비우는 코드
		 */
		postsRepository.deleteAll();
	}
	
	@Test
	public void 게스글저장_불러오기() {
		/*
		 * given, when, then : BDD(Behaviour-Driven Development)에서 사용하는 용어임.
		 * JUnit에서 명시적으로 지원해주지 않음.
		 * 전문 BDD프레임워크로, Groovy기반의 Spock을 많이 사용. 
		 */
		
		//given  => 테스트 기반 환경을 구축하는 단계. @builder의 사용법 확인
		postsRepository.save(Posts.builder()
				.title("테스트 게시글")
				.content("테스트 본문")
				.author("작가명")
				.build());
		
		//when => 테스트 하고자 하는 행위 선언. Posts가 DB에 insert되는 것을 확인.
		List<Posts> postsList = postsRepository.findAll();
		
		//then => 테스트 결과 검증. 실제로 DB에 insert되었는지 확인하기 위해 조회후, 입력된 값 확인.
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("테스트 게시글"));
		assertThat(posts.getContent(), is("테스트 본문"));
		
	}
}
