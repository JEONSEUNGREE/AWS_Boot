package com.example.AWS_BOOT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication
// 위의 어노테이션은 스프링부트의 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정한다.
// 위의 위치부터 설정을 읽어가기 때문에 항상 프로젝트의 최상단에 위치해야한다.
// 또한 내장 WAS를 통해 별도의 외부 WAS를 두지않고 애플리케이션 실행시 내부에서 WAS를 싱행한다.
// 항상 톰캣을 설치할 필요없이 스프링 부트로 만들어진 Jar파일(실행가능한 java 패키징 파일)로 실행하면된다.
// 또한 이렇게 내장 WAS 권장하는 이유가 언제 어디서나 같은 황경에서 배포할 수 있기 때문이다.
// 외장의 경우 종유버전설정이 일치해야하지만 내장의경우 이문제를 해결할수있다.

public class AwsBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwsBootApplication.class, args);
	}

}
