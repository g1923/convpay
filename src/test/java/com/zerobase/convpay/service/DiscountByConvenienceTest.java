package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequeset;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByConvenienceTest {
    DiscountByConvenience discountByConvenience = new DiscountByConvenience();

    @Test
    void discountTest() {
        //given
        PayRequeset payRequesetG25 = new PayRequeset(PayMethodType.MONEY, ConvenienceType.G25, 1000);
        PayRequeset payRequesetCU = new PayRequeset(PayMethodType.MONEY, ConvenienceType.CU, 1000);
        PayRequeset payRequesetSeven = new PayRequeset(PayMethodType.MONEY, ConvenienceType.SEVEN, 1000);

        //when
        Integer discountedAmountG25 = discountByConvenience.getDiscountedAmount(payRequesetG25);
        Integer discountedAmountCU = discountByConvenience.getDiscountedAmount(payRequesetCU);
        Integer discountedAmountSeven = discountByConvenience.getDiscountedAmount(payRequesetSeven);

        //then
        assertEquals(800, discountedAmountG25);
        assertEquals(900, discountedAmountCU);
        assertEquals(1000, discountedAmountSeven);
    }

}