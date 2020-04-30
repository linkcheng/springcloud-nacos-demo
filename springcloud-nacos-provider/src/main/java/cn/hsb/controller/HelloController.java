package cn.hsb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class HelloController {
    @PostMapping("/hello")
    public String sayHello(@RequestBody String name) {
        log.info("Current timestamp="+System.currentTimeMillis()+", name="+name);
        return "Hello " + name;
    }
}
