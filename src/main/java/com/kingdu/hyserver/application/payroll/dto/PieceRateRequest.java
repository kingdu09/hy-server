package com.kingdu.hyserver.application.payroll.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * PieceRate 新增/修改请求 DTO（不含 id 与派生字段）。
 */
public record PieceRateRequest(
        Long specId,
        String processName,
        BigDecimal unitPrice,
        LocalDate effectiveDate,
        Integer status
) {
}
