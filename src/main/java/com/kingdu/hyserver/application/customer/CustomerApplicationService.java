package com.kingdu.hyserver.application.customer;

import com.kingdu.hyserver.application.customer.dto.CustomerRequest;
import com.kingdu.hyserver.application.customer.dto.CustomerResponse;
import com.kingdu.hyserver.domain.customer.Customer;
import com.kingdu.hyserver.domain.customer.CustomerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Customer 应用服务：用例编排，只依赖领域仓储接口。
 */
@Service
public class CustomerApplicationService {

    private final CustomerRepository repository;

    public CustomerApplicationService(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerResponse create(CustomerRequest req) {
        Customer entity = new Customer();
        apply(entity, req);
        return CustomerResponse.from(repository.save(entity));
    }

    public List<CustomerResponse> findAll() {
        return repository.findAll().stream().map(CustomerResponse::from).toList();
    }

    public CustomerResponse findById(Long id) {
        return repository.findById(id).map(CustomerResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found: " + id));
    }

    public CustomerResponse update(Long id, CustomerRequest req) {
        Customer entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Customer not found: " + id));
        apply(entity, req);
        return CustomerResponse.from(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void apply(Customer e, CustomerRequest req) {
        e.setName(req.name());
        e.setContactPerson(req.contactPerson());
        e.setPhone(req.phone());
        e.setAddress(req.address());
        e.setStatus(req.status());
    }
}
