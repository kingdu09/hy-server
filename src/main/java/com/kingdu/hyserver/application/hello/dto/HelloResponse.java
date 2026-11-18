package com.kingdu.hyserver.application.hello.dto;

import java.time.LocalDateTime;

/**
 * 应用层 DTO：对外暴露的 hello 响应数据，隔离领域模型。
 */
public record HelloResponse(String message, LocalDateTime createdAt) {
}
