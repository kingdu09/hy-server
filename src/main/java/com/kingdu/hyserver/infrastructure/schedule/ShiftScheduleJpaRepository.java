package com.kingdu.hyserver.infrastructure.schedule;

import com.kingdu.hyserver.domain.schedule.ShiftSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA 仓储，仅在基础设施层可见。
 */
public interface ShiftScheduleJpaRepository extends JpaRepository<ShiftSchedule, Long> {
}
