package com.zerobase.convpay.dto;

import com.zerobase.convpay.type.ConvenienceType;

public class PayRequeset {
    // 편의점 종류
    ConvenienceType convenienceType;

    public PayRequeset(ConvenienceType convenienceType, Integer payAmount) {
        this.convenienceType = convenienceType;
        this.payAmount = payAmount;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    // 결제 금액
    Integer payAmount;


}
