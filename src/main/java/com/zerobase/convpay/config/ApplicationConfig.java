package com.zerobase.convpay.config;

import com.zerobase.convpay.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashSet;

// 전체 애플리케이션의 설정을 결정함.
@Configuration
public class ApplicationConfig {

    @Bean
    public ConveniencePayService conveniencePayService(){
        return new ConveniencePayService(
                new HashSet<>(
                        Arrays.asList(moneyAdapter(), cardAdapter())
                ),
                getDiscountByConvenience()
        );
    }

    @Bean
    public static CardAdapter cardAdapter() {
        return new CardAdapter();
    }

    @Bean
    public static MoneyAdapter moneyAdapter() {
        return new MoneyAdapter();
    }

    @Bean
    public static DiscountByConvenience getDiscountByConvenience() {
        return new DiscountByConvenience();
    }
}
