package com.kingdu.hyserver.application.production.dto;

import com.kingdu.hyserver.domain.production.ProductionOrder;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ProductionOrder 响应 DTO。
 */
public record ProductionOrderResponse(
        String orderNo,
        Long specId,
        BigDecimal planQuantityKg,
        BigDecimal actualQuantityKg,
        LocalDate productionDate,
        String status,
        String remark,
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static ProductionOrderResponse from(ProductionOrder e) {
        return new ProductionOrderResponse(
                e.getOrderNo(),
                e.getSpecId(),
                e.getPlanQuantityKg(),
                e.getActualQuantityKg(),
                e.getProductionDate(),
                e.getStatus(),
                e.getRemark(),
                e.getId(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }
}
