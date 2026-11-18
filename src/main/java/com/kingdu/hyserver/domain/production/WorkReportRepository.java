package com.kingdu.hyserver.domain.production;

import java.util.List;
import java.util.Optional;

/**
 * WorkReport 仓储接口（领域层，依赖倒置）。
 */
public interface WorkReportRepository {

    WorkReport save(WorkReport entity);

    Optional<WorkReport> findById(Long id);

    List<WorkReport> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
