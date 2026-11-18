package com.kingdu.hyserver.domain.employee;

import java.util.List;
import java.util.Optional;

/**
 * Employee 仓储接口（领域层，依赖倒置）。
 */
public interface EmployeeRepository {

    Employee save(Employee entity);

    Optional<Employee> findById(Long id);

    List<Employee> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
