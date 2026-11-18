package com.kingdu.hyserver.application.material.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * RawMaterial 新增/修改请求 DTO（不含 id 与派生字段）。
 */
public record RawMaterialRequest(
        String name,
        String unit,
        BigDecimal purchasePrice,
        BigDecimal stockKg,
        String description,
        Integer status
) {
}
