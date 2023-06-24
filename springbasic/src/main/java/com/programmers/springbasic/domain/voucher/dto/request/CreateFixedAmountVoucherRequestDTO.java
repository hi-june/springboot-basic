package com.programmers.springbasic.domain.voucher.dto.request;

import lombok.Getter;


@Getter
public class CreateFixedAmountVoucherRequestDTO {
    private static final String VALID_FIXED_AMOUNT_REGEX = "^\\d+(\\.\\d+)?$";  // 숫자와 소수점 허용
    private static final String INVALID_FIXED_AMOUNT_MESSAGE = "숫자만 입력 가능합니다.";

    private String inputFixedAmount;

    public CreateFixedAmountVoucherRequestDTO(String inputFixedAmount) {
        if (!inputFixedAmount.matches(VALID_FIXED_AMOUNT_REGEX)) {
            throw new IllegalArgumentException(INVALID_FIXED_AMOUNT_MESSAGE);
        }

        this.inputFixedAmount = inputFixedAmount;
    }
}
