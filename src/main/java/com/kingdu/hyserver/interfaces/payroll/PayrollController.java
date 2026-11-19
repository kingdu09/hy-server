package com.kingdu.hyserver.interfaces.payroll;

import com.kingdu.hyserver.application.payroll.dto.PayrollRequest;
import com.kingdu.hyserver.application.payroll.dto.PayrollResponse;
import com.kingdu.hyserver.application.payroll.PayrollApplicationService;
import org.springframework.web.bind.annotation.*;
import com.kingdu.hyserver.interfaces.common.ImportResult;
import java.util.List;

/**
 * Payroll 接口层：HTTP 适配，不承载业务逻辑。
 */
@RestController
@RequestMapping("/api/payrolls")
public class PayrollController {

    private final PayrollApplicationService service;

    public PayrollController(PayrollApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public PayrollResponse create(@RequestBody PayrollRequest req) {
        return service.create(req);
    }

    @PostMapping("/import")
    public ImportResult importAll(@RequestBody List<PayrollRequest> reqs) {
        return service.importAll(reqs);
    }

    @GetMapping
    public List<PayrollResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PayrollResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public PayrollResponse update(@PathVariable Long id, @RequestBody PayrollRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
