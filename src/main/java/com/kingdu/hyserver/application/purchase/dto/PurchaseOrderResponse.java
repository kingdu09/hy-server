package com.kingdu.hyserver.application.purchase.dto;

import com.kingdu.hyserver.domain.purchase.PurchaseOrder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * PurchaseOrder 响应 DTO。
 */
public record PurchaseOrderResponse(
        Long materialId,
        Long supplierId,
        BigDecimal quantityKg,
        BigDecimal unitPrice,
        BigDecimal totalAmount,
        LocalDate purchaseDate,
        String remark,
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static PurchaseOrderResponse from(PurchaseOrder e) {
        return new PurchaseOrderResponse(
                e.getMaterialId(),
                e.getSupplierId(),
                e.getQuantityKg(),
                e.getUnitPrice(),
                e.getTotalAmount(),
                e.getPurchaseDate(),
                e.getRemark(),
                e.getId(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }
}
