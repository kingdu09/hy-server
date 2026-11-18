package com.kingdu.hyserver.domain.production;

import java.util.List;
import java.util.Optional;

/**
 * ProductionOrder 仓储接口（领域层，依赖倒置）。
 */
public interface ProductionOrderRepository {

    ProductionOrder save(ProductionOrder entity);

    Optional<ProductionOrder> findById(Long id);

    List<ProductionOrder> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
