package com.kingdu.hyserver.domain.customer;

import java.util.List;
import java.util.Optional;

/**
 * Customer 仓储接口（领域层，依赖倒置）。
 */
public interface CustomerRepository {

    Customer save(Customer entity);

    Optional<Customer> findById(Long id);

    List<Customer> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
