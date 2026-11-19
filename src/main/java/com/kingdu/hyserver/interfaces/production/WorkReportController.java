package com.kingdu.hyserver.interfaces.production;

import com.kingdu.hyserver.application.production.dto.WorkReportRequest;
import com.kingdu.hyserver.application.production.dto.WorkReportResponse;
import com.kingdu.hyserver.application.production.WorkReportApplicationService;
import org.springframework.web.bind.annotation.*;
import com.kingdu.hyserver.interfaces.common.ImportResult;
import java.util.List;

/**
 * WorkReport 接口层：HTTP 适配，不承载业务逻辑。
 */
@RestController
@RequestMapping("/api/work-reports")
public class WorkReportController {

    private final WorkReportApplicationService service;

    public WorkReportController(WorkReportApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public WorkReportResponse create(@RequestBody WorkReportRequest req) {
        return service.create(req);
    }

    @PostMapping("/import")
    public ImportResult importAll(@RequestBody List<WorkReportRequest> reqs) {
        return service.importAll(reqs);
    }

    @GetMapping
    public List<WorkReportResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public WorkReportResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public WorkReportResponse update(@PathVariable Long id, @RequestBody WorkReportRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
