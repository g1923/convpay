package com.zerobase.convpay.config;

import com.zerobase.convpay.ConvpayApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.io.IOException;

// 전체 애플리케이션의 설정을 결정함.
@Configuration
@ComponentScan(basePackageClasses = ConvpayApplication.class) // ConvpayApplication 클래스위치부터 하위 클래스의 모든 파일들을 스캔함을 의미
public class ApplicationConfig {
//    @Autowired
//    private ApplicationContext applicationContext;
//
//    public void getResource() throws IOException {
//        Resource resource = applicationContext.getResource("myTeplate.txt");
//
//        System.out.println(resource.contentLength() + "");
//    }
}