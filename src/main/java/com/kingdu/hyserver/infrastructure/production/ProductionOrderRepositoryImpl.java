package com.kingdu.hyserver.infrastructure.production;

import com.kingdu.hyserver.domain.production.ProductionOrder;
import com.kingdu.hyserver.domain.production.ProductionOrderRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * 仓储实现：委托给 Spring Data JPA，领域接口与技术实现解耦。
 */
@Repository
public class ProductionOrderRepositoryImpl implements ProductionOrderRepository {

    private final ProductionOrderJpaRepository jpaRepository;

    public ProductionOrderRepositoryImpl(ProductionOrderJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ProductionOrder save(ProductionOrder entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Optional<ProductionOrder> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<ProductionOrder> findAll() {
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
