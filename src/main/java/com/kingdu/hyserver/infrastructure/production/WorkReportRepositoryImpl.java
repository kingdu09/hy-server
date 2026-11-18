package com.kingdu.hyserver.infrastructure.production;

import com.kingdu.hyserver.domain.production.WorkReport;
import com.kingdu.hyserver.domain.production.WorkReportRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * 仓储实现：委托给 Spring Data JPA，领域接口与技术实现解耦。
 */
@Repository
public class WorkReportRepositoryImpl implements WorkReportRepository {

    private final WorkReportJpaRepository jpaRepository;

    public WorkReportRepositoryImpl(WorkReportJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public WorkReport save(WorkReport entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Optional<WorkReport> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<WorkReport> findAll() {
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
