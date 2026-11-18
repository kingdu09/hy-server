package com.kingdu.hyserver.infrastructure.sales;

import com.kingdu.hyserver.domain.sales.SalesOrder;
import com.kingdu.hyserver.domain.sales.SalesOrderRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * 仓储实现：委托给 Spring Data JPA，领域接口与技术实现解耦。
 */
@Repository
public class SalesOrderRepositoryImpl implements SalesOrderRepository {

    private final SalesOrderJpaRepository jpaRepository;

    public SalesOrderRepositoryImpl(SalesOrderJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public SalesOrder save(SalesOrder entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Optional<SalesOrder> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<SalesOrder> findAll() {
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
