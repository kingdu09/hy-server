package com.kingdu.hyserver.application.payroll.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Payroll 新增/修改请求 DTO（不含 id 与派生字段）。
 */
public record PayrollRequest(
        Long employeeId,
        String salaryMonth,
        BigDecimal pieceWage,
        BigDecimal overtimePay,
        BigDecimal deductions,
        String status,
        String remark
) {
}
