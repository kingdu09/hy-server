package com.kingdu.hyserver.interfaces.employee;

import com.kingdu.hyserver.application.employee.dto.EmployeeRequest;
import com.kingdu.hyserver.application.employee.dto.EmployeeResponse;
import com.kingdu.hyserver.application.employee.EmployeeApplicationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Employee 接口层：HTTP 适配，不承载业务逻辑。
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeApplicationService service;

    public EmployeeController(EmployeeApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeResponse create(@RequestBody EmployeeRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<EmployeeResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponse update(@PathVariable Long id, @RequestBody EmployeeRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
