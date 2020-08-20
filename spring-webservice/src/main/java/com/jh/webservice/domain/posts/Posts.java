package com.jh.webservice.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.jh.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/*
 * 실제 DB의 테이블과 매칭될 클래스임. Entity클래스 라고한다. 
 * JPA의 경우 실제 쿼리를 날리기 보다는 여기서 수정을 한다.
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED) 
// 기본생성자자동추가
// access = AccessLevel.PROTECTED : 기본생성자의  접근권한을 protected로 제한 protected Posts(){}와 같은 효과임
// => 왜 이렇게씀?? Entity클래스를 프로젝트 코드상에서 기본생성자로 생성하는것은 막되, JPA에서  Entity 클래스를 생성하는 것은 허용하기 위해 추가함.
@Getter
@Entity 

//테이블과 링크될 클래스임을 나타냄 . 언더스코어 네이밍(_)으로 이름을 매칭함 
public class Posts extends BaseTimeEntity{
	//해당 테이블의 PK필드를 나타냄
	// PK의 생성규칙임. 기본값은 AUTO임. 자동증가하는 정수형값(시퀀스같은)
	//Long은 참조타입(Integer같은거), long은 원시타입임(int같은)
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; 
	
	//테이블의 컬럼을 나타내면, 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 딤.
	//기본값 이외에 추가로 변경이 필요한 옵션이 있을 경우 사용.
	@Column(length = 500, nullable = false) //기본값이 varchar(255)인데 500으로 늘리고 변경한다는 뜻임.
	private String title;
	
	@Column(columnDefinition = "TEXT", nullable = false) //타입을 text로 변경하고 싶다는 뜻임.
	private String content;
	
	private String author;
	
	//해당 클래스의 빌더패턴 클래스를 생성 
	//생성자 상단에 선언시 생성자에 포함된 필드만 빌더에 포함.
	@Builder 
	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
	
}
