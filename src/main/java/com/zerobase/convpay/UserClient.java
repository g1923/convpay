package com.zerobase.convpay;

import com.zerobase.convpay.config.ApplicationConfig;
import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.dto.PayRequeset;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.service.ConveniencePayService;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;

public class UserClient {
    public static void main(String[] args) {
        // 사용자 -> 편의점 결제 ->> 머니

        ApplicationConfig applicationConfig = new ApplicationConfig();
        ConveniencePayService conveniencePayService = applicationConfig.conveniencePayServiceDiscountPayMethod();
//        ConveniencePayService conveniencePayService = applicationConfig.conveniencePayServiceDiscountConvenience();

        // 결제 1000원
        PayRequeset payRequeset = new PayRequeset(PayMethodType.CARD,
                ConvenienceType.G25, 50);
        PayResponse payResponse = conveniencePayService.pay(payRequeset);

        System.out.println(payResponse);

        // 취소 500원
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY,
                ConvenienceType.G25, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        System.out.println(payCancelResponse);
    }

}
