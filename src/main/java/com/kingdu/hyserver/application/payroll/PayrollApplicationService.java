package com.kingdu.hyserver.application.payroll;

import com.kingdu.hyserver.application.payroll.dto.PayrollRequest;
import com.kingdu.hyserver.application.payroll.dto.PayrollResponse;
import com.kingdu.hyserver.domain.payroll.Payroll;
import com.kingdu.hyserver.domain.payroll.PayrollRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Payroll 应用服务：用例编排，只依赖领域仓储接口。
 */
@Service
public class PayrollApplicationService {

    private final PayrollRepository repository;

    public PayrollApplicationService(PayrollRepository repository) {
        this.repository = repository;
    }

    public PayrollResponse create(PayrollRequest req) {
        Payroll entity = new Payroll();
        apply(entity, req);
        return PayrollResponse.from(repository.save(entity));
    }

    public List<PayrollResponse> findAll() {
        return repository.findAll().stream().map(PayrollResponse::from).toList();
    }

    public PayrollResponse findById(Long id) {
        return repository.findById(id).map(PayrollResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("Payroll not found: " + id));
    }

    public PayrollResponse update(Long id, PayrollRequest req) {
        Payroll entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Payroll not found: " + id));
        apply(entity, req);
        return PayrollResponse.from(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void apply(Payroll e, PayrollRequest req) {
        e.setEmployeeId(req.employeeId());
        e.setSalaryMonth(req.salaryMonth());
        e.setPieceWage(req.pieceWage());
        e.setOvertimePay(req.overtimePay());
        e.setDeductions(req.deductions());
        e.setStatus(req.status());
        e.setRemark(req.remark());
    }
}
