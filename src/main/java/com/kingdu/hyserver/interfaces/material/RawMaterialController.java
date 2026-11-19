package com.kingdu.hyserver.interfaces.material;

import com.kingdu.hyserver.application.material.dto.RawMaterialRequest;
import com.kingdu.hyserver.application.material.dto.RawMaterialResponse;
import com.kingdu.hyserver.application.material.RawMaterialApplicationService;
import org.springframework.web.bind.annotation.*;
import com.kingdu.hyserver.interfaces.common.ImportResult;
import java.util.List;

/**
 * RawMaterial 接口层：HTTP 适配，不承载业务逻辑。
 */
@RestController
@RequestMapping("/api/raw-materials")
public class RawMaterialController {

    private final RawMaterialApplicationService service;

    public RawMaterialController(RawMaterialApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public RawMaterialResponse create(@RequestBody RawMaterialRequest req) {
        return service.create(req);
    }

    @PostMapping("/import")
    public ImportResult importAll(@RequestBody List<RawMaterialRequest> reqs) {
        return service.importAll(reqs);
    }

    @GetMapping
    public List<RawMaterialResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RawMaterialResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public RawMaterialResponse update(@PathVariable Long id, @RequestBody RawMaterialRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
