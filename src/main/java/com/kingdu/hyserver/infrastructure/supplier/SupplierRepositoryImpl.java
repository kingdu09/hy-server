package com.kingdu.hyserver.infrastructure.supplier;

import com.kingdu.hyserver.domain.supplier.Supplier;
import com.kingdu.hyserver.domain.supplier.SupplierRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * 仓储实现：委托给 Spring Data JPA，领域接口与技术实现解耦。
 */
@Repository
public class SupplierRepositoryImpl implements SupplierRepository {

    private final SupplierJpaRepository jpaRepository;

    public SupplierRepositoryImpl(SupplierJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Supplier save(Supplier entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Optional<Supplier> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Supplier> findAll() {
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
