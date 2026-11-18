package com.kingdu.hyserver.interfaces.schedule;

import com.kingdu.hyserver.application.schedule.dto.ShiftScheduleRequest;
import com.kingdu.hyserver.application.schedule.dto.ShiftScheduleResponse;
import com.kingdu.hyserver.application.schedule.ShiftScheduleApplicationService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * ShiftSchedule 接口层：HTTP 适配，不承载业务逻辑。
 */
@RestController
@RequestMapping("/api/shift-schedules")
public class ShiftScheduleController {

    private final ShiftScheduleApplicationService service;

    public ShiftScheduleController(ShiftScheduleApplicationService service) {
        this.service = service;
    }

    @PostMapping
    public ShiftScheduleResponse create(@RequestBody ShiftScheduleRequest req) {
        return service.create(req);
    }

    @GetMapping
    public List<ShiftScheduleResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ShiftScheduleResponse findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/{id}")
    public ShiftScheduleResponse update(@PathVariable Long id, @RequestBody ShiftScheduleRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
