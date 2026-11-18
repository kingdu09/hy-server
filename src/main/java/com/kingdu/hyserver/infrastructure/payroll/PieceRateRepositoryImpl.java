package com.kingdu.hyserver.infrastructure.payroll;

import com.kingdu.hyserver.domain.payroll.PieceRate;
import com.kingdu.hyserver.domain.payroll.PieceRateRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * 仓储实现：委托给 Spring Data JPA，领域接口与技术实现解耦。
 */
@Repository
public class PieceRateRepositoryImpl implements PieceRateRepository {

    private final PieceRateJpaRepository jpaRepository;

    public PieceRateRepositoryImpl(PieceRateJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public PieceRate save(PieceRate entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Optional<PieceRate> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<PieceRate> findAll() {
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
