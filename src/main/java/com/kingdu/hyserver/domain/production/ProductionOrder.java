package com.kingdu.hyserver.domain.production;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * ProductionOrder 领域实体（聚合根），映射表 production_order。
 * 务实折中：实体直接携带 JPA 注解；依赖方向仍保持纯 inward。
 */
@Entity
@Table(name = "production_order")
public class ProductionOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_no", length = 50, nullable = false, unique = true)
    private String orderNo;

    @Column(name = "spec_id", nullable = false)
    private Long specId;

    @Column(name = "plan_quantity_kg", precision = 10, scale = 2, nullable = false)
    private BigDecimal planQuantityKg;

    @Column(name = "actual_quantity_kg", precision = 10, scale = 2)
    private BigDecimal actualQuantityKg;

    @Column(name = "production_date", nullable = false)
    private LocalDate productionDate;

    @Column(name = "status", length = 20)
    private String status;

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

    public String getOrderNo() { return orderNo; }
    public void setOrderNo(String orderNo) { this.orderNo = orderNo; }

    public Long getSpecId() { return specId; }
    public void setSpecId(Long specId) { this.specId = specId; }

    public BigDecimal getPlanQuantityKg() { return planQuantityKg; }
    public void setPlanQuantityKg(BigDecimal planQuantityKg) { this.planQuantityKg = planQuantityKg; }

    public BigDecimal getActualQuantityKg() { return actualQuantityKg; }
    public void setActualQuantityKg(BigDecimal actualQuantityKg) { this.actualQuantityKg = actualQuantityKg; }

    public LocalDate getProductionDate() { return productionDate; }
    public void setProductionDate(LocalDate productionDate) { this.productionDate = productionDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

}
