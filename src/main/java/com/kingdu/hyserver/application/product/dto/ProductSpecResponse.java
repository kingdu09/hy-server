package com.kingdu.hyserver.application.product.dto;

import com.kingdu.hyserver.domain.product.ProductSpec;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ProductSpec 响应 DTO。
 */
public record ProductSpecResponse(
        String code,
        String name,
        String category,
        String unit,
        BigDecimal salePrice,
        String description,
        Integer status,
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static ProductSpecResponse from(ProductSpec e) {
        return new ProductSpecResponse(
                e.getCode(),
                e.getName(),
                e.getCategory(),
                e.getUnit(),
                e.getSalePrice(),
                e.getDescription(),
                e.getStatus(),
                e.getId(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }
}
