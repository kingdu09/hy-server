package com.kingdu.hyserver.infrastructure.customer;

import com.kingdu.hyserver.domain.customer.Customer;
import com.kingdu.hyserver.domain.customer.CustomerRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * 仓储实现：委托给 Spring Data JPA，领域接口与技术实现解耦。
 */
@Repository
public class CustomerRepositoryImpl implements CustomerRepository {

    private final CustomerJpaRepository jpaRepository;

    public CustomerRepositoryImpl(CustomerJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Customer save(Customer entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<Customer> findAll() {
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
