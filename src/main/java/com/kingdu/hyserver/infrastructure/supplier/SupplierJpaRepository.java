package com.kingdu.hyserver.infrastructure.supplier;

import com.kingdu.hyserver.domain.supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA 仓储，仅在基础设施层可见。
 */
public interface SupplierJpaRepository extends JpaRepository<Supplier, Long> {
}
