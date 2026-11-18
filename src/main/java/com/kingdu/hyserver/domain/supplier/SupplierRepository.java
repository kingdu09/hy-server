package com.kingdu.hyserver.domain.supplier;

import java.util.List;
import java.util.Optional;

/**
 * Supplier 仓储接口（领域层，依赖倒置）。
 */
public interface SupplierRepository {

    Supplier save(Supplier entity);

    Optional<Supplier> findById(Long id);

    List<Supplier> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
