package com.kingdu.hyserver.application.sales.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DeliveryNote 新增/修改请求 DTO（不含 id 与派生字段）。
 */
public record DeliveryNoteRequest(
        Long salesOrderId,
        LocalDate deliveryDate,
        BigDecimal quantityKg,
        BigDecimal unitPrice,
        String remark
) {
}
