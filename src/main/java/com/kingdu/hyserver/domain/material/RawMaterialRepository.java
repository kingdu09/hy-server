package com.kingdu.hyserver.domain.material;

import java.util.List;
import java.util.Optional;

/**
 * RawMaterial 仓储接口（领域层，依赖倒置）。
 */
public interface RawMaterialRepository {

    RawMaterial save(RawMaterial entity);

    Optional<RawMaterial> findById(Long id);

    List<RawMaterial> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
