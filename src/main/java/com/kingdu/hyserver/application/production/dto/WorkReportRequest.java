package com.kingdu.hyserver.application.production.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * WorkReport 新增/修改请求 DTO（不含 id 与派生字段）。
 */
public record WorkReportRequest(
        Long orderId,
        Long employeeId,
        LocalDate reportDate,
        BigDecimal outputKg,
        String remark
) {
}
