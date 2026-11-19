package com.kingdu.hyserver.application.schedule;

import com.kingdu.hyserver.application.schedule.dto.ShiftScheduleRequest;
import com.kingdu.hyserver.application.schedule.dto.ShiftScheduleResponse;
import com.kingdu.hyserver.domain.schedule.ShiftSchedule;
import com.kingdu.hyserver.domain.schedule.ShiftScheduleRepository;
import org.springframework.stereotype.Service;
import com.kingdu.hyserver.interfaces.common.ImportError;
import com.kingdu.hyserver.interfaces.common.ImportResult;
import java.util.ArrayList;
import java.util.List;

/**
 * ShiftSchedule 应用服务：用例编排，只依赖领域仓储接口。
 */
@Service
public class ShiftScheduleApplicationService {

    private final ShiftScheduleRepository repository;

    public ShiftScheduleApplicationService(ShiftScheduleRepository repository) {
        this.repository = repository;
    }

    public ShiftScheduleResponse create(ShiftScheduleRequest req) {
        ShiftSchedule entity = new ShiftSchedule();
        apply(entity, req);
        return ShiftScheduleResponse.from(repository.save(entity));
    }

    public ImportResult importAll(List<ShiftScheduleRequest> reqs) {
        int success = 0;
        List<ImportError> errors = new ArrayList<>();
        for (int i = 0; i < reqs.size(); i++) {
            try {
                create(reqs.get(i));
                success++;
            } catch (Exception e) {
                errors.add(new ImportError(i + 1, e.getMessage()));
            }
        }
        return new ImportResult(reqs.size(), success, errors.size(), errors);
    }

    public List<ShiftScheduleResponse> findAll() {
        return repository.findAll().stream().map(ShiftScheduleResponse::from).toList();
    }

    public ShiftScheduleResponse findById(Long id) {
        return repository.findById(id).map(ShiftScheduleResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("ShiftSchedule not found: " + id));
    }

    public ShiftScheduleResponse update(Long id, ShiftScheduleRequest req) {
        ShiftSchedule entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ShiftSchedule not found: " + id));
        apply(entity, req);
        return ShiftScheduleResponse.from(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void apply(ShiftSchedule e, ShiftScheduleRequest req) {
        e.setEmployeeId(req.employeeId());
        e.setScheduleDate(req.scheduleDate());
        e.setShiftType(req.shiftType());
        e.setWorkHours(req.workHours());
        e.setOvertimeHours(req.overtimeHours());
        e.setRemark(req.remark());
    }
}
