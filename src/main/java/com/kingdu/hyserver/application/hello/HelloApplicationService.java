package com.kingdu.hyserver.application.hello;

import com.kingdu.hyserver.application.hello.dto.HelloResponse;
import com.kingdu.hyserver.domain.hello.Greeting;
import com.kingdu.hyserver.domain.hello.GreetingDomainService;
import com.kingdu.hyserver.domain.hello.GreetingRepository;
import org.springframework.stereotype.Service;

/**
 * 应用服务：编排领域服务与仓储，完成「打招呼」用例，不含领域规则本身。
 */
@Service
public class HelloApplicationService {

    private final GreetingDomainService greetingDomainService;
    private final GreetingRepository greetingRepository;

    public HelloApplicationService(GreetingDomainService greetingDomainService,
                                   GreetingRepository greetingRepository) {
        this.greetingDomainService = greetingDomainService;
        this.greetingRepository = greetingRepository;
    }

    public HelloResponse sayHello(String name) {
        Greeting greeting = greetingDomainService.greet(name);
        Greeting saved = greetingRepository.save(greeting);
        return new HelloResponse(saved.getMessage(), saved.getCreatedAt());
    }
}
