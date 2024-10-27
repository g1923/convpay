package com.zerobase.convpay.service;

import com.zerobase.convpay.type.CancelPaymentResult;
import com.zerobase.convpay.type.PayMethodType;
import com.zerobase.convpay.type.PaymentResult;

// 기존에 만들어 놓은 moneyAdapter와 cardAdapter가 PaymentIntercace에 의존하게 끔 코드 리팩토링
public interface PaymentInterface {
    PayMethodType getPaymentType();
    PaymentResult payment(Integer payAmount);
    CancelPaymentResult cancelPaymentResult(Integer cancelAmount);

}
