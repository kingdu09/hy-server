package com.kingdu.hyserver.domain.payroll;

import java.util.List;
import java.util.Optional;

/**
 * PieceRate 仓储接口（领域层，依赖倒置）。
 */
public interface PieceRateRepository {

    PieceRate save(PieceRate entity);

    Optional<PieceRate> findById(Long id);

    List<PieceRate> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
