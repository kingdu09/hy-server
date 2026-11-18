package com.kingdu.hyserver.infrastructure.production;

import com.kingdu.hyserver.domain.production.ProductionOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA 仓储，仅在基础设施层可见。
 */
public interface ProductionOrderJpaRepository extends JpaRepository<ProductionOrder, Long> {
}
