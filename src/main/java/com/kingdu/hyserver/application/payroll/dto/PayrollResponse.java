package com.kingdu.hyserver.application.payroll.dto;

import com.kingdu.hyserver.domain.payroll.Payroll;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Payroll 响应 DTO。
 */
public record PayrollResponse(
        Long employeeId,
        String salaryMonth,
        BigDecimal pieceWage,
        BigDecimal overtimePay,
        BigDecimal deductions,
        BigDecimal netPay,
        String status,
        String remark,
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static PayrollResponse from(Payroll e) {
        return new PayrollResponse(
                e.getEmployeeId(),
                e.getSalaryMonth(),
                e.getPieceWage(),
                e.getOvertimePay(),
                e.getDeductions(),
                e.getNetPay(),
                e.getStatus(),
                e.getRemark(),
                e.getId(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }
}
