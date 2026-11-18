package com.kingdu.hyserver.application.production.dto;

import com.kingdu.hyserver.domain.production.WorkReport;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * WorkReport 响应 DTO。
 */
public record WorkReportResponse(
        Long orderId,
        Long employeeId,
        LocalDate reportDate,
        BigDecimal outputKg,
        String remark,
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static WorkReportResponse from(WorkReport e) {
        return new WorkReportResponse(
                e.getOrderId(),
                e.getEmployeeId(),
                e.getReportDate(),
                e.getOutputKg(),
                e.getRemark(),
                e.getId(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }
}
