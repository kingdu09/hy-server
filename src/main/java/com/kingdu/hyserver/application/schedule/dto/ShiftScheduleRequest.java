package com.kingdu.hyserver.application.schedule.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * ShiftSchedule 新增/修改请求 DTO（不含 id 与派生字段）。
 */
public record ShiftScheduleRequest(
        Long employeeId,
        LocalDate scheduleDate,
        String shiftType,
        BigDecimal workHours,
        BigDecimal overtimeHours,
        String remark
) {
}
