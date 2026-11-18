package com.kingdu.hyserver.domain.sales;

import java.util.List;
import java.util.Optional;

/**
 * SalesOrder 仓储接口（领域层，依赖倒置）。
 */
public interface SalesOrderRepository {

    SalesOrder save(SalesOrder entity);

    Optional<SalesOrder> findById(Long id);

    List<SalesOrder> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
