package com.kingdu.hyserver.infrastructure.payroll;

import com.kingdu.hyserver.domain.payroll.Payroll;
import com.kingdu.hyserver.domain.payroll.PayrollRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * 仓储实现：委托给 Spring Data JPA，领域接口与技术实现解耦。
 */
@Repository
public class PayrollRepositoryImpl implements PayrollRepository {

    private final PayrollJpaRepository jpaRepository;

    public PayrollRepositoryImpl(PayrollJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Payroll save(Payroll entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Optional<Payroll> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Payroll> findAll() {
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
