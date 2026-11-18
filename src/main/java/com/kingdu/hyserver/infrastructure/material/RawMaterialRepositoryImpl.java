package com.kingdu.hyserver.infrastructure.material;

import com.kingdu.hyserver.domain.material.RawMaterial;
import com.kingdu.hyserver.domain.material.RawMaterialRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

/**
 * 仓储实现：委托给 Spring Data JPA，领域接口与技术实现解耦。
 */
@Repository
public class RawMaterialRepositoryImpl implements RawMaterialRepository {

    private final RawMaterialJpaRepository jpaRepository;

    public RawMaterialRepositoryImpl(RawMaterialJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public RawMaterial save(RawMaterial entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Optional<RawMaterial> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<RawMaterial> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return jpaRepository.existsById(id);
    }
}
