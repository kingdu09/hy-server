package com.kingdu.hyserver.application.purchase;

import com.kingdu.hyserver.application.purchase.dto.PurchaseOrderRequest;
import com.kingdu.hyserver.application.purchase.dto.PurchaseOrderResponse;
import com.kingdu.hyserver.domain.purchase.PurchaseOrder;
import com.kingdu.hyserver.domain.purchase.PurchaseOrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * PurchaseOrder 应用服务：用例编排，只依赖领域仓储接口。
 */
@Service
public class PurchaseOrderApplicationService {

    private final PurchaseOrderRepository repository;

    public PurchaseOrderApplicationService(PurchaseOrderRepository repository) {
        this.repository = repository;
    }

    public PurchaseOrderResponse create(PurchaseOrderRequest req) {
        PurchaseOrder entity = new PurchaseOrder();
        apply(entity, req);
        return PurchaseOrderResponse.from(repository.save(entity));
    }

    public List<PurchaseOrderResponse> findAll() {
        return repository.findAll().stream().map(PurchaseOrderResponse::from).toList();
    }

    public PurchaseOrderResponse findById(Long id) {
        return repository.findById(id).map(PurchaseOrderResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("PurchaseOrder not found: " + id));
    }

    public PurchaseOrderResponse update(Long id, PurchaseOrderRequest req) {
        PurchaseOrder entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PurchaseOrder not found: " + id));
        apply(entity, req);
        return PurchaseOrderResponse.from(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void apply(PurchaseOrder e, PurchaseOrderRequest req) {
        e.setMaterialId(req.materialId());
        e.setSupplierId(req.supplierId());
        e.setQuantityKg(req.quantityKg());
        e.setUnitPrice(req.unitPrice());
        e.setPurchaseDate(req.purchaseDate());
        e.setRemark(req.remark());
    }
}
