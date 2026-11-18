package com.kingdu.hyserver.domain.hello;

import org.springframework.stereotype.Service;

/**
 * 领域服务：封装问候语生成这一领域规则，不感知 HTTP、DTO 等外部概念。
 */
@Service
public class GreetingDomainService {

    public Greeting greet(String name) {
        String target = (name == null || name.isBlank()) ? "World" : name;
        return Greeting.create("Hello, " + target + "!");
    }
}
