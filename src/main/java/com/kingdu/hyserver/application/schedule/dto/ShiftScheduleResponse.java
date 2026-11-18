package com.kingdu.hyserver.application.schedule.dto;

import com.kingdu.hyserver.domain.schedule.ShiftSchedule;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ShiftSchedule 响应 DTO。
 */
public record ShiftScheduleResponse(
        Long employeeId,
        LocalDate scheduleDate,
        String shiftType,
        BigDecimal workHours,
        BigDecimal overtimeHours,
        String remark,
        Long id,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static ShiftScheduleResponse from(ShiftSchedule e) {
        return new ShiftScheduleResponse(
                e.getEmployeeId(),
                e.getScheduleDate(),
                e.getShiftType(),
                e.getWorkHours(),
                e.getOvertimeHours(),
                e.getRemark(),
                e.getId(),
                e.getCreatedAt(),
                e.getUpdatedAt()
        );
    }
}
