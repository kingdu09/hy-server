package com.kingdu.hyserver.infrastructure.purchase;

import com.kingdu.hyserver.domain.purchase.PurchaseOrder;
import com.kingdu.hyserver.domain.purchase.PurchaseOrderRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * 仓储实现：委托给 Spring Data JPA，领域接口与技术实现解耦。
 */
@Repository
public class PurchaseOrderRepositoryImpl implements PurchaseOrderRepository {

    private final PurchaseOrderJpaRepository jpaRepository;

    public PurchaseOrderRepositoryImpl(PurchaseOrderJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public PurchaseOrder save(PurchaseOrder entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Optional<PurchaseOrder> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<PurchaseOrder> findAll() {
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
