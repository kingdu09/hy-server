package com.kingdu.hyserver.domain.payroll;

import java.util.List;
import java.util.Optional;

/**
 * Payroll 仓储接口（领域层，依赖倒置）。
 */
public interface PayrollRepository {

    Payroll save(Payroll entity);

    Optional<Payroll> findById(Long id);

    List<Payroll> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
