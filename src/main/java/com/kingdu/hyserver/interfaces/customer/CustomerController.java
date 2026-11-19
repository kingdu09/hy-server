package com.kingdu.hyserver.interfaces.customer;

import com.kingdu.hyserver.application.customer.dto.CustomerRequest;
import com.kingdu.hyserver.application.customer.dto.CustomerResponse;
import com.kingdu.hyserver.application.customer.CustomerApplicationService;
import org.springframework.web.bind.annotation.*;
import com.kingdu.hyserver.interfaces.common.ImportResult;
import java.util.List;

/**
 * Customer 接口层：HTTP 适配，不承载业务逻辑。
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerApplicationService service;

    public CustomerController(CustomerApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerResponse create(@RequestBody CustomerRequest req) {
        return service.create(req);
    }

    @PostMapping("/import")
    public ImportResult importAll(@RequestBody List<CustomerRequest> reqs) {
        return service.importAll(reqs);
    }

    @GetMapping
    public List<CustomerResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CustomerResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public CustomerResponse update(@PathVariable Long id, @RequestBody CustomerRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
