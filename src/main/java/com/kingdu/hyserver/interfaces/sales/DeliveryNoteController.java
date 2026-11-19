package com.kingdu.hyserver.interfaces.sales;

import com.kingdu.hyserver.application.sales.dto.DeliveryNoteRequest;
import com.kingdu.hyserver.application.sales.dto.DeliveryNoteResponse;
import com.kingdu.hyserver.application.sales.DeliveryNoteApplicationService;
import org.springframework.web.bind.annotation.*;
import com.kingdu.hyserver.interfaces.common.ImportResult;
import java.util.List;

/**
 * DeliveryNote 接口层：HTTP 适配，不承载业务逻辑。
 */
@RestController
@RequestMapping("/api/delivery-notes")
public class DeliveryNoteController {

    private final DeliveryNoteApplicationService service;

    public DeliveryNoteController(DeliveryNoteApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public DeliveryNoteResponse create(@RequestBody DeliveryNoteRequest req) {
        return service.create(req);
    }

    @PostMapping("/import")
    public ImportResult importAll(@RequestBody List<DeliveryNoteRequest> reqs) {
        return service.importAll(reqs);
    }

    @GetMapping
    public List<DeliveryNoteResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public DeliveryNoteResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public DeliveryNoteResponse update(@PathVariable Long id, @RequestBody DeliveryNoteRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
