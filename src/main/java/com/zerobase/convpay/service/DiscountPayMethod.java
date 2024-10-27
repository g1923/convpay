package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequeset;

public class DiscountPayMethod implements DiscountInterface{
    @Override
    public Integer getDiscountedAmount(PayRequeset payRequeset) {
        switch (payRequeset.getPayMethodType()) {
            case MONEY -> {
                return payRequeset.getPayAmount() * 7 / 10;
            }
            case CARD -> {
                return payRequeset.getPayAmount();
            }
        }
        return payRequeset.getPayAmount();
    }
}
