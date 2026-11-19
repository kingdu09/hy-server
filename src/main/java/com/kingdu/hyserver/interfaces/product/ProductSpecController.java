package com.kingdu.hyserver.interfaces.product;

import com.kingdu.hyserver.application.product.dto.ProductSpecRequest;
import com.kingdu.hyserver.application.product.dto.ProductSpecResponse;
import com.kingdu.hyserver.application.product.ProductSpecApplicationService;
import org.springframework.web.bind.annotation.*;
import com.kingdu.hyserver.interfaces.common.ImportResult;
import java.util.List;

/**
 * ProductSpec 接口层：HTTP 适配，不承载业务逻辑。
 */
@RestController
@RequestMapping("/api/product-specs")
public class ProductSpecController {

    private final ProductSpecApplicationService service;

    public ProductSpecController(ProductSpecApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public ProductSpecResponse create(@RequestBody ProductSpecRequest req) {
        return service.create(req);
    }

    @PostMapping("/import")
    public ImportResult importAll(@RequestBody List<ProductSpecRequest> reqs) {
        return service.importAll(reqs);
    }

    @GetMapping
    public List<ProductSpecResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProductSpecResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ProductSpecResponse update(@PathVariable Long id, @RequestBody ProductSpecRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
