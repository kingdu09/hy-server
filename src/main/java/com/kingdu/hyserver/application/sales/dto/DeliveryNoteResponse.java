package com.kingdu.hyserver.application.sales.dto;

import com.kingdu.hyserver.domain.sales.DeliveryNote;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * DeliveryNote 响应 DTO。
 */
public record DeliveryNoteResponse(
        Long salesOrderId,
        LocalDate deliveryDate,
        BigDecimal quantityKg,
        BigDecimal unitPrice,
        BigDecimal totalAmount,
        String remark,
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static DeliveryNoteResponse from(DeliveryNote e) {
        return new DeliveryNoteResponse(
                e.getSalesOrderId(),
                e.getDeliveryDate(),
                e.getQuantityKg(),
                e.getUnitPrice(),
                e.getTotalAmount(),
                e.getRemark(),
                e.getId(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }
}
