package com.kingdu.hyserver.application.sales;

import com.kingdu.hyserver.application.sales.dto.DeliveryNoteRequest;
import com.kingdu.hyserver.application.sales.dto.DeliveryNoteResponse;
import com.kingdu.hyserver.domain.sales.DeliveryNote;
import com.kingdu.hyserver.domain.sales.DeliveryNoteRepository;
import org.springframework.stereotype.Service;
import com.kingdu.hyserver.interfaces.common.ImportError;
import com.kingdu.hyserver.interfaces.common.ImportResult;
import java.util.ArrayList;
import java.util.List;

/**
 * DeliveryNote 应用服务：用例编排，只依赖领域仓储接口。
 */
@Service
public class DeliveryNoteApplicationService {

    private final DeliveryNoteRepository repository;

    public DeliveryNoteApplicationService(DeliveryNoteRepository repository) {
        this.repository = repository;
    }

    public DeliveryNoteResponse create(DeliveryNoteRequest req) {
        DeliveryNote entity = new DeliveryNote();
        apply(entity, req);
        return DeliveryNoteResponse.from(repository.save(entity));
    }

    public ImportResult importAll(List<DeliveryNoteRequest> reqs) {
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

    public List<DeliveryNoteResponse> findAll() {
        return repository.findAll().stream().map(DeliveryNoteResponse::from).toList();
    }

    public DeliveryNoteResponse findById(Long id) {
        return repository.findById(id).map(DeliveryNoteResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("DeliveryNote not found: " + id));
    }

    public DeliveryNoteResponse update(Long id, DeliveryNoteRequest req) {
        DeliveryNote entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("DeliveryNote not found: " + id));
        apply(entity, req);
        return DeliveryNoteResponse.from(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void apply(DeliveryNote e, DeliveryNoteRequest req) {
        e.setSalesOrderId(req.salesOrderId());
        e.setDeliveryDate(req.deliveryDate());
        e.setQuantityKg(req.quantityKg());
        e.setUnitPrice(req.unitPrice());
        e.setRemark(req.remark());
    }
}
