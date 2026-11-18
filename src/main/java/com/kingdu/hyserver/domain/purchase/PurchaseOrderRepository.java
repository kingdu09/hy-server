package com.kingdu.hyserver.domain.purchase;

import java.util.List;
import java.util.Optional;

/**
 * PurchaseOrder 仓储接口（领域层，依赖倒置）。
 */
public interface PurchaseOrderRepository {

    PurchaseOrder save(PurchaseOrder entity);

    Optional<PurchaseOrder> findById(Long id);

    List<PurchaseOrder> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
