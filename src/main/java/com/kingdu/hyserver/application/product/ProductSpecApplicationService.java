package com.kingdu.hyserver.application.product;

import com.kingdu.hyserver.application.product.dto.ProductSpecRequest;
import com.kingdu.hyserver.application.product.dto.ProductSpecResponse;
import com.kingdu.hyserver.domain.product.ProductSpec;
import com.kingdu.hyserver.domain.product.ProductSpecRepository;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * ProductSpec 应用服务：用例编排，只依赖领域仓储接口。
 */
@Service
public class ProductSpecApplicationService {

    private final ProductSpecRepository repository;

    public ProductSpecApplicationService(ProductSpecRepository repository) {
        this.repository = repository;
    }

    public ProductSpecResponse create(ProductSpecRequest req) {
        ProductSpec entity = new ProductSpec();
        apply(entity, req);
        return ProductSpecResponse.from(repository.save(entity));
    }

    public List<ProductSpecResponse> findAll() {
        return repository.findAll().stream().map(ProductSpecResponse::from).toList();
    }

    public ProductSpecResponse findById(Long id) {
        return repository.findById(id).map(ProductSpecResponse::from)
                .orElseThrow(() -> new IllegalArgumentException("ProductSpec not found: " + id));
    }

    public ProductSpecResponse update(Long id, ProductSpecRequest req) {
        ProductSpec entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ProductSpec not found: " + id));
        apply(entity, req);
        return ProductSpecResponse.from(repository.save(entity));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    private void apply(ProductSpec e, ProductSpecRequest req) {
        e.setCode(req.code());
        e.setName(req.name());
        e.setCategory(req.category());
        e.setUnit(req.unit());
        e.setSalePrice(req.salePrice());
        e.setDescription(req.description());
        e.setStatus(req.status());
    }
}
