package com.zerobase.convpay;

import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.dto.PayRequeset;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.service.ConveniencePayService;
import com.zerobase.convpay.type.ConvenienceType;

public class UserClient {
    public static void main(String[] args) {
        // 사용자 -> 편의점 결제 ->> 머니

        ConveniencePayService conveniencePayService = new ConveniencePayService();

        // 결제 1000원
        PayRequeset payRequeset = new PayRequeset(ConvenienceType.G25, 1000);
        PayResponse payResponse = conveniencePayService.pay(payRequeset);

        System.out.println(payResponse);

        // 취소 500원
        PayCancelRequest payCancelRequest = new PayCancelRequest(ConvenienceType.G25, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancle(payCancelRequest);

        System.out.println();
    }

}
