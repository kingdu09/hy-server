package com.kingdu.hyserver.application.sales.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * SalesOrder 新增/修改请求 DTO（不含 id 与派生字段）。
 */
public record SalesOrderRequest(
        Long customerId,
        Long specId,
        BigDecimal quantityKg,
        BigDecimal unitPrice,
        LocalDate orderDate,
        LocalDate deliveryDate,
        String status,
        String remark
) {
}
