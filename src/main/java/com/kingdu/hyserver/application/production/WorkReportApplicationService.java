package com.kingdu.hyserver.application.production;

import com.kingdu.hyserver.application.production.dto.WorkReportRequest;
import com.kingdu.hyserver.application.production.dto.WorkReportResponse;
import com.kingdu.hyserver.domain.production.WorkReport;
import com.kingdu.hyserver.domain.production.WorkReportRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * WorkReport 应用服务：用例编排，只依赖领域仓储接口。
 */
@Service
public class WorkReportApplicationService {

    private final WorkReportRepository repository;

    public WorkReportApplicationService(WorkReportRepository repository) {
        this.repository = repository;
    }

    public WorkReportResponse create(WorkReportRequest req) {
        WorkReport entity = new WorkReport();
        apply(entity, req);
        return WorkReportResponse.from(repository.save(entity));
    }

    public List<WorkReportResponse> findAll() {
        return repository.findAll().stream().map(WorkReportResponse::from).toList();
    }

    public WorkReportResponse findById(Long id) {
        return repository.findById(id).map(WorkReportResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("WorkReport not found: " + id));
    }

    public WorkReportResponse update(Long id, WorkReportRequest req) {
        WorkReport entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("WorkReport not found: " + id));
        apply(entity, req);
        return WorkReportResponse.from(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void apply(WorkReport e, WorkReportRequest req) {
        e.setOrderId(req.orderId());
        e.setEmployeeId(req.employeeId());
        e.setReportDate(req.reportDate());
        e.setOutputKg(req.outputKg());
        e.setRemark(req.remark());
    }
}
