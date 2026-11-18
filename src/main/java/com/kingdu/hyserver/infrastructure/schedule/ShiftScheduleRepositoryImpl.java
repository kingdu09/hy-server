package com.kingdu.hyserver.infrastructure.schedule;

import com.kingdu.hyserver.domain.schedule.ShiftSchedule;
import com.kingdu.hyserver.domain.schedule.ShiftScheduleRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * 仓储实现：委托给 Spring Data JPA，领域接口与技术实现解耦。
 */
@Repository
public class ShiftScheduleRepositoryImpl implements ShiftScheduleRepository {

    private final ShiftScheduleJpaRepository jpaRepository;

    public ShiftScheduleRepositoryImpl(ShiftScheduleJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public ShiftSchedule save(ShiftSchedule entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Optional<ShiftSchedule> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<ShiftSchedule> findAll() {
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
