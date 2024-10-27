package com.zerobase.convpay.service;

import com.zerobase.convpay.dto.PayRequeset;

public interface DiscountInterface {
    Integer getDiscountedAmount(PayRequeset payRequeset);
}
