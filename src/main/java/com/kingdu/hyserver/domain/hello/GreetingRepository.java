package com.kingdu.hyserver.domain.hello;

/**
 * 领域仓储接口：领域层只依赖抽象，具体实现放在基础设施层（依赖倒置）。
 */
public interface GreetingRepository {

    Greeting save(Greeting greeting);
}
