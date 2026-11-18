package com.kingdu.hyserver.application.product.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * ProductSpec 新增/修改请求 DTO（不含 id 与派生字段）。
 */
public record ProductSpecRequest(
        String code,
        String name,
        String category,
        String unit,
        BigDecimal salePrice,
        String description,
        Integer status
) {
}
