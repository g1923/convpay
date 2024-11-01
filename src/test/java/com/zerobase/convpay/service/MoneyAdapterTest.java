package com.zerobase.convpay.service;

import com.zerobase.convpay.type.MoneyUseCancelResult;
import com.zerobase.convpay.type.MoneyUseResult;
import org.junit.jupiter.api.Test;

import static com.zerobase.convpay.type.MoneyUseResult.USE_FAIL;
import static com.zerobase.convpay.type.MoneyUseResult.USE_SUCCESS;
import static org.junit.jupiter.api.Assertions.*;

class MoneyAdapterTest {

    MoneyAdapter moneyAdapter = new MoneyAdapter();

    @Test
    void money_use_fail() {
        //given
        Integer payAmount = 1000_001;

        //when
        MoneyUseResult moneyUseResult = moneyAdapter.use(payAmount);

        //then
        assertEquals(USE_FAIL, moneyUseResult);
    }

    @Test
    void money_use_success() {
        //given
        Integer payAmount = 1000_000;

        //when
        MoneyUseResult moneyUseResult = moneyAdapter.use(payAmount);

        //then
        assertEquals(USE_SUCCESS, moneyUseResult);
    }

    @Test
    void money_use_cancle_success() {
        //given
        Integer payCancleAmount = 100;

        //when
        MoneyUseCancelResult moneyUseCancleResult = moneyAdapter.useCancel(payCancleAmount);

        //then
        assertEquals(MoneyUseCancelResult.MONEY_USE_CANCEL_SUCCESS, moneyUseCancleResult);
    }

    @Test
    void money_use_cancle_fail() {
        //given
        Integer payCancleAmount = 99;

        //when
        MoneyUseCancelResult moneyUseCancleResult = moneyAdapter.useCancel(payCancleAmount);

        //then
        assertEquals(MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL, moneyUseCancleResult);
    }
}