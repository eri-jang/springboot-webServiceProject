package com.jh.webservice.domain.posts;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

//MyBatis에서 Dao인 곳. DB Layer접근자
//JPA에선 Repository라고 부르며, 인터페이스로 생성한다.
//interface 생성후, JpaRepository<Entity클래스, PK타입S>를 상속하면 기본적인 CRUD 메소드가 자동생성됨.

public interface PostsRepository extends JpaRepository<Posts, Long> {
	@Query("SELECT p " + 
			"FROM Posts p " +
			"ORDER BY p.id DESC")
	Stream<Posts> findAllDesc();
	
}
