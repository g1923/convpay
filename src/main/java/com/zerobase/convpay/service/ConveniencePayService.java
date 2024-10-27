package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.*;
import com.zerobase.convpay.type.MoneyUseCancelResult;
import com.zerobase.convpay.type.MoneyUseResult;
import com.zerobase.convpay.type.PayCancelResult;
import com.zerobase.convpay.type.PayResult;

// 편의점 결제 시스템
public class ConveniencePayService {
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();

    public PayResponse pay(PayRequeset payRequeset) {
        MoneyUseResult moneyUseResult =
                moneyAdapter.use(payRequeset.getPayAmount());

        if (moneyUseResult == MoneyUseResult.USE_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }

        // 예외케이스들이 언제 어떻게 존재할지 모르기 때문에 단하나의 성공케이스를 맨마지막 리턴값으로 보냄
        // SUCCESS CASE
        return new PayResponse(PayResult.SUCCESS, payRequeset.getPayAmount());
    }

    public PayCancelResponse payCancle(PayCancelRequest payCancleRequest) {
        MoneyUseCancelResult moneyUseCancleResult =
                moneyAdapter.useCancel(payCancleRequest.getPayCancelAmount());

        if (moneyUseCancleResult == MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS, payCancleRequest.getPayCancelAmount());
    }
}
