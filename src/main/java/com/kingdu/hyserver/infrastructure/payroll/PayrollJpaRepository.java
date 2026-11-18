package com.kingdu.hyserver.infrastructure.payroll;

import com.kingdu.hyserver.domain.payroll.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA 仓储，仅在基础设施层可见。
 */
public interface PayrollJpaRepository extends JpaRepository<Payroll, Long> {
}
