package com.kingdu.hyserver.application.material.dto;

import com.kingdu.hyserver.domain.material.RawMaterial;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * RawMaterial 响应 DTO。
 */
public record RawMaterialResponse(
        String name,
        String unit,
        BigDecimal purchasePrice,
        BigDecimal stockKg,
        String description,
        Integer status,
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static RawMaterialResponse from(RawMaterial e) {
        return new RawMaterialResponse(
                e.getName(),
                e.getUnit(),
                e.getPurchasePrice(),
                e.getStockKg(),
                e.getDescription(),
                e.getStatus(),
                e.getId(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }
}
