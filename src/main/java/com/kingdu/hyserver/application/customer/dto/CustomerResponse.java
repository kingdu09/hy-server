package com.kingdu.hyserver.application.customer.dto;

import com.kingdu.hyserver.domain.customer.Customer;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Customer 响应 DTO。
 */
public record CustomerResponse(
        String name,
        String contactPerson,
        String phone,
        String address,
        Integer status,
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static CustomerResponse from(Customer e) {
        return new CustomerResponse(
                e.getName(),
                e.getContactPerson(),
                e.getPhone(),
                e.getAddress(),
                e.getStatus(),
                e.getId(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }
}
