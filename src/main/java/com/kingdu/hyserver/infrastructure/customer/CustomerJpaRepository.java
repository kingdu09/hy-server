package com.kingdu.hyserver.infrastructure.customer;

import com.kingdu.hyserver.domain.customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA 仓储，仅在基础设施层可见。
 */
public interface CustomerJpaRepository extends JpaRepository<Customer, Long> {
}
