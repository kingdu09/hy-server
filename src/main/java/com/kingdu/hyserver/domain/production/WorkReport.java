package com.kingdu.hyserver.domain.production;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * WorkReport 领域实体（聚合根），映射表 work_report。
 * 务实折中：实体直接携带 JPA 注解；依赖方向仍保持纯 inward。
 */
@Entity
@Table(name = "work_report")
public class WorkReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_id", nullable = false)
    private Long orderId;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "report_date", nullable = false)
    private LocalDate reportDate;

    @Column(name = "output_kg", precision = 10, scale = 2, nullable = false)
    private BigDecimal outputKg;

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

    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public LocalDate getReportDate() { return reportDate; }
    public void setReportDate(LocalDate reportDate) { this.reportDate = reportDate; }

    public BigDecimal getOutputKg() { return outputKg; }
    public void setOutputKg(BigDecimal outputKg) { this.outputKg = outputKg; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

}
