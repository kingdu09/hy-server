package com.kingdu.hyserver.application.purchase.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * PurchaseOrder 新增/修改请求 DTO（不含 id 与派生字段）。
 */
public record PurchaseOrderRequest(
        Long materialId,
        Long supplierId,
        BigDecimal quantityKg,
        BigDecimal unitPrice,
        LocalDate purchaseDate,
        String remark
) {
}
