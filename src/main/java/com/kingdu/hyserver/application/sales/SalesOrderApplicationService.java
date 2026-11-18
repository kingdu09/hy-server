package com.kingdu.hyserver.application.sales;

import com.kingdu.hyserver.application.sales.dto.SalesOrderRequest;
import com.kingdu.hyserver.application.sales.dto.SalesOrderResponse;
import com.kingdu.hyserver.domain.sales.SalesOrder;
import com.kingdu.hyserver.domain.sales.SalesOrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * SalesOrder 应用服务：用例编排，只依赖领域仓储接口。
 */
@Service
public class SalesOrderApplicationService {

    private final SalesOrderRepository repository;

    public SalesOrderApplicationService(SalesOrderRepository repository) {
        this.repository = repository;
    }

    public SalesOrderResponse create(SalesOrderRequest req) {
        SalesOrder entity = new SalesOrder();
        apply(entity, req);
        return SalesOrderResponse.from(repository.save(entity));
    }

    public List<SalesOrderResponse> findAll() {
        return repository.findAll().stream().map(SalesOrderResponse::from).toList();
    }

    public SalesOrderResponse findById(Long id) {
        return repository.findById(id).map(SalesOrderResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("SalesOrder not found: " + id));
    }

    public SalesOrderResponse update(Long id, SalesOrderRequest req) {
        SalesOrder entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("SalesOrder not found: " + id));
        apply(entity, req);
        return SalesOrderResponse.from(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void apply(SalesOrder e, SalesOrderRequest req) {
        e.setCustomerId(req.customerId());
        e.setSpecId(req.specId());
        e.setQuantityKg(req.quantityKg());
        e.setUnitPrice(req.unitPrice());
        e.setOrderDate(req.orderDate());
        e.setDeliveryDate(req.deliveryDate());
        e.setStatus(req.status());
        e.setRemark(req.remark());
    }
}
