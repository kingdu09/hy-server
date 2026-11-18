package com.kingdu.hyserver.application.supplier.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Supplier 新增/修改请求 DTO（不含 id 与派生字段）。
 */
public record SupplierRequest(
        String name,
        String contactPerson,
        String phone,
        String address,
        Integer status
) {
}
