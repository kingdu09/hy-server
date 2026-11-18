package com.kingdu.hyserver.application.employee.dto;

import com.kingdu.hyserver.domain.employee.Employee;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Employee 响应 DTO。
 */
public record EmployeeResponse(
        String name,
        String phone,
        String position,
        BigDecimal baseSalary,
        LocalDate hireDate,
        Integer status,
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static EmployeeResponse from(Employee e) {
        return new EmployeeResponse(
                e.getName(),
                e.getPhone(),
                e.getPosition(),
                e.getBaseSalary(),
                e.getHireDate(),
                e.getStatus(),
                e.getId(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }
}
