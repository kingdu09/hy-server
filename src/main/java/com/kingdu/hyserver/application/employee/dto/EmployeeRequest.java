package com.kingdu.hyserver.application.employee.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Employee 新增/修改请求 DTO（不含 id 与派生字段）。
 */
public record EmployeeRequest(
        String name,
        String phone,
        String position,
        BigDecimal baseSalary,
        LocalDate hireDate,
        Integer status
) {
}
