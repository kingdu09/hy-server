package com.kingdu.hyserver.infrastructure.hello;

import com.kingdu.hyserver.domain.hello.Greeting;
import com.kingdu.hyserver.domain.hello.GreetingRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 基础设施层：仓储的内存实现（演示用，生产环境可替换为数据库实现）。
 */
@Repository
public class InMemoryGreetingRepository implements GreetingRepository {

    private final AtomicLong idGenerator = new AtomicLong(0);

    @Override
    public Greeting save(Greeting greeting) {
        Long id = idGenerator.incrementAndGet();
        return Greeting.restore(id, greeting.getMessage(), greeting.getCreatedAt());
    }
}
