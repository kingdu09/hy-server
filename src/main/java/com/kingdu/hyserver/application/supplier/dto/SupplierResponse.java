package com.kingdu.hyserver.application.supplier.dto;

import com.kingdu.hyserver.domain.supplier.Supplier;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Supplier 响应 DTO。
 */
public record SupplierResponse(
        String name,
        String contactPerson,
        String phone,
        String address,
        Integer status,
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static SupplierResponse from(Supplier e) {
        return new SupplierResponse(
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
