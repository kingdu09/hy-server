package com.kingdu.hyserver.interfaces.supplier;

import com.kingdu.hyserver.application.supplier.dto.SupplierRequest;
import com.kingdu.hyserver.application.supplier.dto.SupplierResponse;
import com.kingdu.hyserver.application.supplier.SupplierApplicationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Supplier 接口层：HTTP 适配，不承载业务逻辑。
 */
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierApplicationService service;

    public SupplierController(SupplierApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public SupplierResponse create(@RequestBody SupplierRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<SupplierResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public SupplierResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public SupplierResponse update(@PathVariable Long id, @RequestBody SupplierRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
