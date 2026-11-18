package com.kingdu.hyserver.domain.schedule;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ShiftSchedule 领域实体（聚合根），映射表 shift_schedule。
 * 务实折中：实体直接携带 JPA 注解；依赖方向仍保持纯 inward。
 */
@Entity
@Table(name = "shift_schedule")
public class ShiftSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "schedule_date", nullable = false)
    private LocalDate scheduleDate;

    @Column(name = "shift_type", length = 20, nullable = false)
    private String shiftType;

    @Column(name = "work_hours", precision = 4, scale = 1)
    private BigDecimal workHours;

    @Column(name = "overtime_hours", precision = 4, scale = 1)
    private BigDecimal overtimeHours;

    @Column(name = "remark", length = 500)
    private String remark;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
        computeAmounts();
    }

    @PreUpdate
    void onUpdate() {
        this.updatedAt = LocalDateTime.now();
        computeAmounts();
    }

    /** 实体级金额/工资计算，落库前自动执行。 */
    private void computeAmounts() {
        // 本实体无派生金额字段
    }

    private static BigDecimal nz(BigDecimal v) { return v == null ? BigDecimal.ZERO : v; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public LocalDate getScheduleDate() { return scheduleDate; }
    public void setScheduleDate(LocalDate scheduleDate) { this.scheduleDate = scheduleDate; }

    public String getShiftType() { return shiftType; }
    public void setShiftType(String shiftType) { this.shiftType = shiftType; }

    public BigDecimal getWorkHours() { return workHours; }
    public void setWorkHours(BigDecimal workHours) { this.workHours = workHours; }

    public BigDecimal getOvertimeHours() { return overtimeHours; }
    public void setOvertimeHours(BigDecimal overtimeHours) { this.overtimeHours = overtimeHours; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

}
