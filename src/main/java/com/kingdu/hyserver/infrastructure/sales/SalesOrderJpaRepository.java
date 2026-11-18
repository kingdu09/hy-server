package com.kingdu.hyserver.infrastructure.sales;

import com.kingdu.hyserver.domain.sales.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA 仓储，仅在基础设施层可见。
 */
public interface SalesOrderJpaRepository extends JpaRepository<SalesOrder, Long> {
}
