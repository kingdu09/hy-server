package com.kingdu.hyserver.domain.hello;

import java.time.LocalDateTime;

/**
 * 问候聚合根（领域实体）。领域层不依赖任何框架或基础设施。
 */
public class Greeting {

    private final Long id;
    private final String message;
    private final LocalDateTime createdAt;

    private Greeting(Long id, String message, LocalDateTime createdAt) {
        this.id = id;
        this.message = message;
        this.createdAt = createdAt;
    }

    /** 创建一个新的问候实体。 */
    public static Greeting create(String message) {
        return new Greeting(null, message, LocalDateTime.now());
    }

    /** 重建一个已持久化的问候实体。 */
    public static Greeting restore(Long id, String message, LocalDateTime createdAt) {
        return new Greeting(id, message, createdAt);
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
