package com.kingdu.hyserver.domain.product;

import java.util.List;
import java.util.Optional;

/**
 * ProductSpec 仓储接口（领域层，依赖倒置）。
 */
public interface ProductSpecRepository {

    ProductSpec save(ProductSpec entity);

    Optional<ProductSpec> findById(Long id);

    List<ProductSpec> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
