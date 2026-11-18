package com.kingdu.hyserver.infrastructure.production;

import com.kingdu.hyserver.domain.production.WorkReport;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data JPA 仓储，仅在基础设施层可见。
 */
public interface WorkReportJpaRepository extends JpaRepository<WorkReport, Long> {
}
