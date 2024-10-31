package com.zerobase.convpay.config;

import com.zerobase.convpay.ConvpayApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 전체 애플리케이션의 설정을 결정함.
@Configuration
//@ComponentScan(basePackages = "com.zerobase.convpay")
@ComponentScan(basePackageClasses = ConvpayApplication.class) // ConvpayApplication 클래스위치부터 하위 클래스의 모든 파일들을 스캔함을 의미
public class ApplicationConfig {


}

/*
DI를 다양한 방법 4가지 을 배워봄.
    1) xml 로 일일이 bean을 등록함
    2) xml componentscan을 이용하여 bean을 등록함
    3) javaConfig로 일일이 bean을 등록하는 방법
    4) javaConfig로 componentscan을 하는 방법
*/


/*
* SpringBoot에서는 ApplicationConfig를 설정하지 않아도됨.
* ConvpayApplication.java에서 이미 설정되어서 파일이 생성됨

@SpringBootApplication
public class ConvpayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConvpayApplication.class, args);
	}

}
* */