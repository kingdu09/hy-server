package com.kingdu.hyserver.application.customer.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Customer 新增/修改请求 DTO（不含 id 与派生字段）。
 */
public record CustomerRequest(
        String name,
        String contactPerson,
        String phone,
        String address,
        Integer status
) {
}
