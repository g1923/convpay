package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
/*
 * singletone : 재활용
 * request : 요청에 따라 새로 만듦
 * prototype: 매번 새로 만듦
 * session : 세션마다 새로 만듦
 * */
// 편의점 결제 시스템
public class ConveniencePayService {
    private final Map<PayMethodType, PaymentInterface> paymentInterfaceMap =
            new HashMap<>();
    private final DiscountInterface discountInterface;

    public ConveniencePayService(Set<PaymentInterface> paymentInterfaceSet,
                                 @Qualifier("discountByConvenience") // DiscountByConvenience 클래스의 첫글자를 소문자로
                                 DiscountInterface discountInterface) {
        paymentInterfaceSet.forEach(
                paymentInterface -> paymentInterfaceMap.put(
                        paymentInterface.getPaymentType(),
                        paymentInterface
                )
        );
        this.discountInterface = discountInterface;
    }

    public PayResponse pay(PayRequeset payRequeset) {
        PaymentInterface paymentInterface = paymentInterfaceMap.get(payRequeset.getPayMethodType());

        // 할인 금액 적용
        Integer discountedAmount = discountInterface.getDiscountedAmount(payRequeset);
        PaymentResult paymentResult = paymentInterface.payment(discountedAmount);

        if(paymentResult == PaymentResult.PAYMENT_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }

        // 예외케이스들이 언제 어떻게 존재할지 모르기 때문에 단하나의 성공케이스를 맨마지막 리턴값으로 보냄
        // SUCCESS CASE
        return new PayResponse(PayResult.SUCCESS, discountedAmount);
    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface = paymentInterfaceMap.get(payCancelRequest.getPayMethodType());

        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPaymentResult(payCancelRequest.getPayCancelAmount());

        if (cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelRequest.getPayCancelAmount());
    }
}
