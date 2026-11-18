package com.kingdu.hyserver.infrastructure.sales;

import com.kingdu.hyserver.domain.sales.DeliveryNote;
import com.kingdu.hyserver.domain.sales.DeliveryNoteRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * 仓储实现：委托给 Spring Data JPA，领域接口与技术实现解耦。
 */
@Repository
public class DeliveryNoteRepositoryImpl implements DeliveryNoteRepository {

    private final DeliveryNoteJpaRepository jpaRepository;

    public DeliveryNoteRepositoryImpl(DeliveryNoteJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public DeliveryNote save(DeliveryNote entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Optional<DeliveryNote> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<DeliveryNote> findAll() {
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
