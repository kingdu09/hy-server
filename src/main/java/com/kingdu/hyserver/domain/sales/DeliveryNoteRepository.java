package com.kingdu.hyserver.domain.sales;

import java.util.List;
import java.util.Optional;

/**
 * DeliveryNote 仓储接口（领域层，依赖倒置）。
 */
public interface DeliveryNoteRepository {

    DeliveryNote save(DeliveryNote entity);

    Optional<DeliveryNote> findById(Long id);

    List<DeliveryNote> findAll();

    void deleteById(Long id);

    boolean existsById(Long id);
}
