package com.kingdu.hyserver.infrastructure.product;

import com.kingdu.hyserver.domain.product.ProductSpec;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA 仓储，仅在基础设施层可见。
 */
public interface ProductSpecJpaRepository extends JpaRepository<ProductSpec, Long> {
}
