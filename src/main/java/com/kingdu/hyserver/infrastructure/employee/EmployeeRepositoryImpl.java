package com.kingdu.hyserver.infrastructure.employee;

import com.kingdu.hyserver.domain.employee.Employee;
import com.kingdu.hyserver.domain.employee.EmployeeRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * 仓储实现：委托给 Spring Data JPA，领域接口与技术实现解耦。
 */
@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EmployeeJpaRepository jpaRepository;

    public EmployeeRepositoryImpl(EmployeeJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Employee save(Employee entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Employee> findAll() {
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
