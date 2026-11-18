package com.kingdu.hyserver.interfaces.production;

import com.kingdu.hyserver.application.production.dto.ProductionOrderRequest;
import com.kingdu.hyserver.application.production.dto.ProductionOrderResponse;
import com.kingdu.hyserver.application.production.ProductionOrderApplicationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * ProductionOrder 接口层：HTTP 适配，不承载业务逻辑。
 */
@RestController
@RequestMapping("/api/production-orders")
public class ProductionOrderController {

    private final ProductionOrderApplicationService service;

    public ProductionOrderController(ProductionOrderApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public ProductionOrderResponse create(@RequestBody ProductionOrderRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<ProductionOrderResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductionOrderResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ProductionOrderResponse update(@PathVariable Long id, @RequestBody ProductionOrderRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
