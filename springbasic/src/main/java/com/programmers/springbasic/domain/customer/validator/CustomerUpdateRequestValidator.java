package com.programmers.springbasic.domain.customer.validator;

import com.programmers.springbasic.domain.customer.dto.request.CustomerUpdateRequestDTO;
import lombok.Getter;

@Getter
public class CustomerUpdateRequestValidator {
    private static final String VALID_EMAIL_REGEXP = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String INVALID_NAME_MESSAGE = "공백은 이름으로 사용할 수 없습니다.";
    private static final String INVALID_EMAIL_MESSAGE = "잘못된 이메일 형식입니다.";

    public static void validateUpdateCustomerRequest(CustomerUpdateRequestDTO customerUpdateRequestDTO) {
        String customerId = customerUpdateRequestDTO.getCustomerId();
        String name = customerUpdateRequestDTO.getName();
        String email = customerUpdateRequestDTO.getEmail();

        CustomerIdValidator.validateCustomerId(customerId);

        if (name.isBlank()) {
            throw new IllegalArgumentException(INVALID_NAME_MESSAGE);
        }

        if (!email.matches(VALID_EMAIL_REGEXP)) {
            throw new IllegalArgumentException(INVALID_EMAIL_MESSAGE);
        }
    }
}
