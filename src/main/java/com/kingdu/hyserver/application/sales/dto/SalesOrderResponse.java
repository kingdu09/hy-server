package com.kingdu.hyserver.application.sales.dto;

import com.kingdu.hyserver.domain.sales.SalesOrder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * SalesOrder 响应 DTO。
 */
public record SalesOrderResponse(
        Long customerId,
        Long specId,
        BigDecimal quantityKg,
        BigDecimal unitPrice,
        BigDecimal totalAmount,
        LocalDate orderDate,
        LocalDate deliveryDate,
        String status,
        String remark,
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static SalesOrderResponse from(SalesOrder e) {
        return new SalesOrderResponse(
                e.getCustomerId(),
                e.getSpecId(),
                e.getQuantityKg(),
                e.getUnitPrice(),
                e.getTotalAmount(),
                e.getOrderDate(),
                e.getDeliveryDate(),
                e.getStatus(),
                e.getRemark(),
                e.getId(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }
}
