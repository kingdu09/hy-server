package com.kingdu.hyserver.application.material;

import com.kingdu.hyserver.application.material.dto.RawMaterialRequest;
import com.kingdu.hyserver.application.material.dto.RawMaterialResponse;
import com.kingdu.hyserver.domain.material.RawMaterial;
import com.kingdu.hyserver.domain.material.RawMaterialRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * RawMaterial 应用服务：用例编排，只依赖领域仓储接口。
 */
@Service
public class RawMaterialApplicationService {

    private final RawMaterialRepository repository;

    public RawMaterialApplicationService(RawMaterialRepository repository) {
        this.repository = repository;
    }

    public RawMaterialResponse create(RawMaterialRequest req) {
        RawMaterial entity = new RawMaterial();
        apply(entity, req);
        return RawMaterialResponse.from(repository.save(entity));
    }

    public List<RawMaterialResponse> findAll() {
        return repository.findAll().stream().map(RawMaterialResponse::from).toList();
    }

    public RawMaterialResponse findById(Long id) {
        return repository.findById(id).map(RawMaterialResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("RawMaterial not found: " + id));
    }

    public RawMaterialResponse update(Long id, RawMaterialRequest req) {
        RawMaterial entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("RawMaterial not found: " + id));
        apply(entity, req);
        return RawMaterialResponse.from(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void apply(RawMaterial e, RawMaterialRequest req) {
        e.setName(req.name());
        e.setUnit(req.unit());
        e.setPurchasePrice(req.purchasePrice());
        e.setStockKg(req.stockKg());
        e.setDescription(req.description());
        e.setStatus(req.status());
    }
}
