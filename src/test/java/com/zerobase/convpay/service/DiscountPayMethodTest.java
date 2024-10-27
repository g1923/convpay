package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequeset;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountPayMethodTest {
    DiscountPayMethod discountPayMethod = new DiscountPayMethod();

    @Test
    void discount_success() {
        //given
        PayRequeset payRequesetMoney = new PayRequeset(PayMethodType.MONEY, ConvenienceType.G25, 1000);
        PayRequeset payRequesetCard = new PayRequeset(PayMethodType.CARD, ConvenienceType.G25, 1000);

        //when
        Integer discountedAmountMoney = discountPayMethod.getDiscountedAmount(payRequesetMoney);
        Integer discountedAmountCard = discountPayMethod.getDiscountedAmount(payRequesetCard);

        //then
        assertEquals(700, discountedAmountMoney);
        assertEquals(1000, discountedAmountCard);
    }
}