package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.*;

// 편의점 결제 시스템
public class ConveniencePayService {
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    private final CardAdapter cardAdapter = new CardAdapter();
    private final DiscountInterface discountInterface = new DiscountPayMethod();
//    private final DiscountInterface discountInterface = new DiscountByConvenience();

    public PayResponse pay(PayRequeset payRequeset) {
        PaymentInterface paymentInterface;

        if (payRequeset.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }

//        PaymentResult paymentResult = paymentInterface.payment(payRequeset.getPayAmount());

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
        PaymentInterface paymentInterface;

        if (payCancelRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }

        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPaymentResult(payCancelRequest.getPayCancelAmount());

        if (cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancelRequest.getPayCancelAmount());
    }
}
