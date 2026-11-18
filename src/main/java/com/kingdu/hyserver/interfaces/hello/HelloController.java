package com.kingdu.hyserver.interfaces.hello;

import com.kingdu.hyserver.application.hello.HelloApplicationService;
import com.kingdu.hyserver.application.hello.dto.HelloResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 接口层：HTTP 入口，只做协议适配与参数绑定，不承载业务逻辑。
 */
@RestController
@RequestMapping("/api/hello")
public class HelloController {

    private final HelloApplicationService helloApplicationService;

    public HelloController(HelloApplicationService helloApplicationService) {
        this.helloApplicationService = helloApplicationService;
    }

    @GetMapping
    public HelloResponse hello(
            @RequestParam(value = "name", defaultValue = "World") String name) {
        return helloApplicationService.sayHello(name);
    }
}
