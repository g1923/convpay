package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequeset;

public class DiscountByConvenience implements DiscountInterface{
    @Override
    public Integer getDiscountedAmount(PayRequeset payRequeset) {

        switch (payRequeset.getConvenienceType()) {
            case G25 -> {
                return payRequeset.getPayAmount() * 8 / 10;
            }
            case CU -> {
                return payRequeset.getPayAmount() * 9 / 10;
            }
            case SEVEN -> {
                return payRequeset.getPayAmount();
            }
        }
        return payRequeset.getPayAmount();
    }
}
