package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayCancelRequest;
import com.zerobase.convpay.dto.PayCancelResponse;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.dto.PayRequeset;
import com.zerobase.convpay.dto.PayResponse;
import com.zerobase.convpay.type.PayCancelResult;
import com.zerobase.convpay.type.PayMethodType;
import com.zerobase.convpay.type.PayResult;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConveniencePayServiceTest {
    ConveniencePayService conveniencePayService = new ConveniencePayService();

    @Test
    void pay_success() {
        //given
        PayRequeset payRequeset = new PayRequeset(PayMethodType.MONEY, ConvenienceType.G25, 50);

        //when
        PayResponse payResponse = conveniencePayService.pay(payRequeset);

        //then
        assertEquals(PayResult.SUCCESS, payResponse.getPayResult());
        assertEquals(50, payResponse.getPaidAmount());
    }

    @Test
    void pay_fail() {
        //given
        PayRequeset payRequeset = new PayRequeset(PayMethodType.MONEY, ConvenienceType.G25, 1000_001);

        //when
        PayResponse payResponse = conveniencePayService.pay(payRequeset);

        //then
        assertEquals(PayResult.FAIL, payResponse.getPayResult());
        assertEquals(0, payResponse.getPaidAmount());
    }


    @Test
    void pay_cancle_success() {
        //given
        PayCancelRequest payCancleRequest = new PayCancelRequest(PayMethodType.MONEY, ConvenienceType.G25, 1000);

        //when
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancleRequest);

        //then
        assertEquals(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelResponse.getPayCancelResult());
        assertEquals(1000, payCancelResponse.getPayCanceledAmount());
    }

    @Test
    void pay_cancle_fail() {
        //given
        PayCancelRequest payCancleRequest = new PayCancelRequest(PayMethodType.MONEY, ConvenienceType.G25, 99);

        //when
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancleRequest);

        //then
        assertEquals(PayCancelResult.PAY_CANCEL_FAIL, payCancelResponse.getPayCancelResult());
        assertEquals(0, payCancelResponse.getPayCanceledAmount());
    }
}