package com.zerobase.convpay.config;

import com.zerobase.convpay.service.*;

import java.util.Arrays;
import java.util.HashSet;

// 전체 애플리케이션의 설정을 결정함.
public class ApplicationConfig {
    public ConveniencePayService conveniencePayServiceDiscountConvenience(){
        return new ConveniencePayService(
                new HashSet<>(
                        Arrays.asList(new MoneyAdapter(), new CardAdapter())
                ),
                new DiscountByConvenience()
        );
    }

    public ConveniencePayService conveniencePayServiceDiscountPayMethod(){
        return new ConveniencePayService(
                new HashSet<>(
                        Arrays.asList(new MoneyAdapter(), new CardAdapter())
                ),
                new DiscountPayMethod()
        );
    }
}
