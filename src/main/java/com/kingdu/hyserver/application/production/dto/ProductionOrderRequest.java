package com.kingdu.hyserver.application.production.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * ProductionOrder 新增/修改请求 DTO（不含 id 与派生字段）。
 */
public record ProductionOrderRequest(
        String orderNo,
        Long specId,
        BigDecimal planQuantityKg,
        BigDecimal actualQuantityKg,
        LocalDate productionDate,
        String status,
        String remark
) {
}
