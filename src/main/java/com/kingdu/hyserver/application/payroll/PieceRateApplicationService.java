package com.kingdu.hyserver.application.payroll;

import com.kingdu.hyserver.application.payroll.dto.PieceRateRequest;
import com.kingdu.hyserver.application.payroll.dto.PieceRateResponse;
import com.kingdu.hyserver.domain.payroll.PieceRate;
import com.kingdu.hyserver.domain.payroll.PieceRateRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * PieceRate 应用服务：用例编排，只依赖领域仓储接口。
 */
@Service
public class PieceRateApplicationService {

    private final PieceRateRepository repository;

    public PieceRateApplicationService(PieceRateRepository repository) {
        this.repository = repository;
    }

    public PieceRateResponse create(PieceRateRequest req) {
        PieceRate entity = new PieceRate();
        apply(entity, req);
        return PieceRateResponse.from(repository.save(entity));
    }

    public List<PieceRateResponse> findAll() {
        return repository.findAll().stream().map(PieceRateResponse::from).toList();
    }

    public PieceRateResponse findById(Long id) {
        return repository.findById(id).map(PieceRateResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("PieceRate not found: " + id));
    }

    public PieceRateResponse update(Long id, PieceRateRequest req) {
        PieceRate entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("PieceRate not found: " + id));
        apply(entity, req);
        return PieceRateResponse.from(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void apply(PieceRate e, PieceRateRequest req) {
        e.setSpecId(req.specId());
        e.setProcessName(req.processName());
        e.setUnitPrice(req.unitPrice());
        e.setEffectiveDate(req.effectiveDate());
        e.setStatus(req.status());
    }
}
