package com.kingdu.hyserver.interfaces.purchase;

import com.kingdu.hyserver.application.purchase.dto.PurchaseOrderRequest;
import com.kingdu.hyserver.application.purchase.dto.PurchaseOrderResponse;
import com.kingdu.hyserver.application.purchase.PurchaseOrderApplicationService;
import org.springframework.web.bind.annotation.*;
import com.kingdu.hyserver.interfaces.common.ImportResult;
import java.util.List;

/**
 * PurchaseOrder 接口层：HTTP 适配，不承载业务逻辑。
 */
@RestController
@RequestMapping("/api/purchase-orders")
public class PurchaseOrderController {

    private final PurchaseOrderApplicationService service;

    public PurchaseOrderController(PurchaseOrderApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public PurchaseOrderResponse create(@RequestBody PurchaseOrderRequest req) {
        return service.create(req);
    }

    @PostMapping("/import")
    public ImportResult importAll(@RequestBody List<PurchaseOrderRequest> reqs) {
        return service.importAll(reqs);
    }

    @GetMapping
    public List<PurchaseOrderResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PurchaseOrderResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public PurchaseOrderResponse update(@PathVariable Long id, @RequestBody PurchaseOrderRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
