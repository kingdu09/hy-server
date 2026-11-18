package com.kingdu.hyserver.interfaces.sales;

import com.kingdu.hyserver.application.sales.dto.SalesOrderRequest;
import com.kingdu.hyserver.application.sales.dto.SalesOrderResponse;
import com.kingdu.hyserver.application.sales.SalesOrderApplicationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * SalesOrder 接口层：HTTP 适配，不承载业务逻辑。
 */
@RestController
@RequestMapping("/api/sales-orders")
public class SalesOrderController {

    private final SalesOrderApplicationService service;

    public SalesOrderController(SalesOrderApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public SalesOrderResponse create(@RequestBody SalesOrderRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<SalesOrderResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SalesOrderResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public SalesOrderResponse update(@PathVariable Long id, @RequestBody SalesOrderRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
