package com.kingdu.hyserver.domain.payroll;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Payroll 领域实体（聚合根），映射表 payroll。
 * 务实折中：实体直接携带 JPA 注解；依赖方向仍保持纯 inward。
 */
@Entity
@Table(name = "payroll")
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @Column(name = "salary_month", length = 7, nullable = false)
    private String salaryMonth;

    @Column(name = "piece_wage", precision = 10, scale = 2)
    private BigDecimal pieceWage;

    @Column(name = "overtime_pay", precision = 10, scale = 2)
    private BigDecimal overtimePay;

    @Column(name = "deductions", precision = 10, scale = 2)
    private BigDecimal deductions;

    @Column(name = "net_pay", precision = 10, scale = 2)
    private BigDecimal netPay;

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
        this.netPay = nz(pieceWage).add(nz(overtimePay)).subtract(nz(deductions));
    }

    private static BigDecimal nz(BigDecimal v) { return v == null ? BigDecimal.ZERO : v; }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public String getSalaryMonth() { return salaryMonth; }
    public void setSalaryMonth(String salaryMonth) { this.salaryMonth = salaryMonth; }

    public BigDecimal getPieceWage() { return pieceWage; }
    public void setPieceWage(BigDecimal pieceWage) { this.pieceWage = pieceWage; }

    public BigDecimal getOvertimePay() { return overtimePay; }
    public void setOvertimePay(BigDecimal overtimePay) { this.overtimePay = overtimePay; }

    public BigDecimal getDeductions() { return deductions; }
    public void setDeductions(BigDecimal deductions) { this.deductions = deductions; }

    public BigDecimal getNetPay() { return netPay; }
    public void setNetPay(BigDecimal netPay) { this.netPay = netPay; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }

}
