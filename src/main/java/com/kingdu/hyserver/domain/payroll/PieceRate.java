package com.kingdu.hyserver.domain.payroll;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * PieceRate 领域实体（聚合根），映射表 piece_rate。
 * 务实折中：实体直接携带 JPA 注解；依赖方向仍保持纯 inward。
 */
@Entity
@Table(name = "piece_rate")
public class PieceRate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "spec_id", nullable = false)
    private Long specId;

    @Column(name = "process_name", length = 50, nullable = false)
    private String processName;

    @Column(name = "unit_price", precision = 10, scale = 4, nullable = false)
    private BigDecimal unitPrice;

    @Column(name = "effective_date")
    private LocalDate effectiveDate;

    @Column(name = "status")
    private Integer status;

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

    public Long getSpecId() { return specId; }
    public void setSpecId(Long specId) { this.specId = specId; }

    public String getProcessName() { return processName; }
    public void setProcessName(String processName) { this.processName = processName; }

    public BigDecimal getUnitPrice() { return unitPrice; }
    public void setUnitPrice(BigDecimal unitPrice) { this.unitPrice = unitPrice; }

    public LocalDate getEffectiveDate() { return effectiveDate; }
    public void setEffectiveDate(LocalDate effectiveDate) { this.effectiveDate = effectiveDate; }

    public Integer getStatus() { return status; }
    public void setStatus(Integer status) { this.status = status; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

}
