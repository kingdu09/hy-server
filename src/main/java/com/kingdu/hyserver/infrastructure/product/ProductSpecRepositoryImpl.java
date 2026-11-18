package com.kingdu.hyserver.infrastructure.product;

import com.kingdu.hyserver.domain.product.ProductSpec;
import com.kingdu.hyserver.domain.product.ProductSpecRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * 仓储实现：委托给 Spring Data JPA，领域接口与技术实现解耦。
 */
@Repository
public class ProductSpecRepositoryImpl implements ProductSpecRepository {

    private final ProductSpecJpaRepository jpaRepository;

    public ProductSpecRepositoryImpl(ProductSpecJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ProductSpec save(ProductSpec entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Optional<ProductSpec> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<ProductSpec> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }
}
