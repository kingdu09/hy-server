package com.kingdu.hyserver.application.supplier;

import com.kingdu.hyserver.application.supplier.dto.SupplierRequest;
import com.kingdu.hyserver.application.supplier.dto.SupplierResponse;
import com.kingdu.hyserver.domain.supplier.Supplier;
import com.kingdu.hyserver.domain.supplier.SupplierRepository;
import org.springframework.stereotype.Service;
import com.kingdu.hyserver.interfaces.common.ImportError;
import com.kingdu.hyserver.interfaces.common.ImportResult;
import java.util.ArrayList;
import java.util.List;

/**
 * Supplier 应用服务：用例编排，只依赖领域仓储接口。
 */
@Service
public class SupplierApplicationService {

    private final SupplierRepository repository;

    public SupplierApplicationService(SupplierRepository repository) {
        this.repository = repository;
    }

    public SupplierResponse create(SupplierRequest req) {
        Supplier entity = new Supplier();
        apply(entity, req);
        return SupplierResponse.from(repository.save(entity));
    }

    public ImportResult importAll(List<SupplierRequest> reqs) {
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

    public List<SupplierResponse> findAll() {
        return repository.findAll().stream().map(SupplierResponse::from).toList();
    }

    public SupplierResponse findById(Long id) {
        return repository.findById(id).map(SupplierResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found: " + id));
    }

    public SupplierResponse update(Long id, SupplierRequest req) {
        Supplier entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Supplier not found: " + id));
        apply(entity, req);
        return SupplierResponse.from(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void apply(Supplier e, SupplierRequest req) {
        e.setName(req.name());
        e.setContactPerson(req.contactPerson());
        e.setPhone(req.phone());
        e.setAddress(req.address());
        e.setStatus(req.status());
    }
}
