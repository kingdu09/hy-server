package com.kingdu.hyserver.application.employee;

import com.kingdu.hyserver.application.employee.dto.EmployeeRequest;
import com.kingdu.hyserver.application.employee.dto.EmployeeResponse;
import com.kingdu.hyserver.domain.employee.Employee;
import com.kingdu.hyserver.domain.employee.EmployeeRepository;
import org.springframework.stereotype.Service;
import com.kingdu.hyserver.interfaces.common.ImportError;
import com.kingdu.hyserver.interfaces.common.ImportResult;
import java.util.ArrayList;
import java.util.List;

/**
 * Employee 应用服务：用例编排，只依赖领域仓储接口。
 */
@Service
public class EmployeeApplicationService {

    private final EmployeeRepository repository;

    public EmployeeApplicationService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public EmployeeResponse create(EmployeeRequest req) {
        Employee entity = new Employee();
        apply(entity, req);
        return EmployeeResponse.from(repository.save(entity));
    }

    public ImportResult importAll(List<EmployeeRequest> reqs) {
        int success = 0;
        List<ImportError> errors = new ArrayList<>();
        for (int i = 0; i < reqs.size(); i++) {
            try {
                create(reqs.get(i));
                success++;
            } catch (Exception e) {
                errors.add(new ImportError(i + 1, e.getMessage()));
            }
        }
        return new ImportResult(reqs.size(), success, errors.size(), errors);
    }

    public List<EmployeeResponse> findAll() {
        return repository.findAll().stream().map(EmployeeResponse::from).toList();
    }

    public EmployeeResponse findById(Long id) {
        return repository.findById(id).map(EmployeeResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found: " + id));
    }

    public EmployeeResponse update(Long id, EmployeeRequest req) {
        Employee entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee not found: " + id));
        apply(entity, req);
        return EmployeeResponse.from(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void apply(Employee e, EmployeeRequest req) {
        e.setName(req.name());
        e.setPhone(req.phone());
        e.setPosition(req.position());
        e.setBaseSalary(req.baseSalary());
        e.setHireDate(req.hireDate());
        e.setStatus(req.status());
    }
}
