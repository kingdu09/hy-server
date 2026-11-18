package com.kingdu.hyserver.application.production;

import com.kingdu.hyserver.application.production.dto.ProductionOrderRequest;
import com.kingdu.hyserver.application.production.dto.ProductionOrderResponse;
import com.kingdu.hyserver.domain.production.ProductionOrder;
import com.kingdu.hyserver.domain.production.ProductionOrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * ProductionOrder 应用服务：用例编排，只依赖领域仓储接口。
 */
@Service
public class ProductionOrderApplicationService {

    private final ProductionOrderRepository repository;

    public ProductionOrderApplicationService(ProductionOrderRepository repository) {
        this.repository = repository;
    }

    public ProductionOrderResponse create(ProductionOrderRequest req) {
        ProductionOrder entity = new ProductionOrder();
        apply(entity, req);
        return ProductionOrderResponse.from(repository.save(entity));
    }

    public List<ProductionOrderResponse> findAll() {
        return repository.findAll().stream().map(ProductionOrderResponse::from).toList();
    }

    public ProductionOrderResponse findById(Long id) {
        return repository.findById(id).map(ProductionOrderResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("ProductionOrder not found: " + id));
    }

    public ProductionOrderResponse update(Long id, ProductionOrderRequest req) {
        ProductionOrder entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ProductionOrder not found: " + id));
        apply(entity, req);
        return ProductionOrderResponse.from(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void apply(ProductionOrder e, ProductionOrderRequest req) {
        e.setOrderNo(req.orderNo());
        e.setSpecId(req.specId());
        e.setPlanQuantityKg(req.planQuantityKg());
        e.setActualQuantityKg(req.actualQuantityKg());
        e.setProductionDate(req.productionDate());
        e.setStatus(req.status());
        e.setRemark(req.remark());
    }
}
