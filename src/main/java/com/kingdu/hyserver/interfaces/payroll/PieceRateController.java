package com.kingdu.hyserver.interfaces.payroll;

import com.kingdu.hyserver.application.payroll.dto.PieceRateRequest;
import com.kingdu.hyserver.application.payroll.dto.PieceRateResponse;
import com.kingdu.hyserver.application.payroll.PieceRateApplicationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * PieceRate 接口层：HTTP 适配，不承载业务逻辑。
 */
@RestController
@RequestMapping("/api/piece-rates")
public class PieceRateController {

    private final PieceRateApplicationService service;

    public PieceRateController(PieceRateApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public PieceRateResponse create(@RequestBody PieceRateRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<PieceRateResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PieceRateResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public PieceRateResponse update(@PathVariable Long id, @RequestBody PieceRateRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
