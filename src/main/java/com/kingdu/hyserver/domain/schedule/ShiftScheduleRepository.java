package com.kingdu.hyserver.domain.schedule;

import java.util.List;
import java.util.Optional;

/**
 * ShiftSchedule 仓储接口（领域层，依赖倒置）。
 */
public interface ShiftScheduleRepository {

    ShiftSchedule save(ShiftSchedule entity);

    Optional<ShiftSchedule> findById(Long id);

    List<ShiftSchedule> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
