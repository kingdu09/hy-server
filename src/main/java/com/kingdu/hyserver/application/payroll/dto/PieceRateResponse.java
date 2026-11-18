package com.kingdu.hyserver.application.payroll.dto;

import com.kingdu.hyserver.domain.payroll.PieceRate;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * PieceRate 响应 DTO。
 */
public record PieceRateResponse(
        Long specId,
        String processName,
        BigDecimal unitPrice,
        LocalDate effectiveDate,
        Integer status,
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static PieceRateResponse from(PieceRate e) {
        return new PieceRateResponse(
                e.getSpecId(),
                e.getProcessName(),
                e.getUnitPrice(),
                e.getEffectiveDate(),
                e.getStatus(),
                e.getId(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }
}
