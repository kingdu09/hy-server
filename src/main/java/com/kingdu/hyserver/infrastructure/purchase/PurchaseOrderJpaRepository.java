package com.kingdu.hyserver.infrastructure.purchase;

import com.kingdu.hyserver.domain.purchase.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA 仓储，仅在基础设施层可见。
 */
public interface PurchaseOrderJpaRepository extends JpaRepository<PurchaseOrder, Long> {
}
