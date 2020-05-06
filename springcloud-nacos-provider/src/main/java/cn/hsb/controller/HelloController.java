package cn.hsb.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class HelloController {
    @PostMapping("/hello")
    public String sayHello(@RequestBody String name) {
        log.info("Current timestamp="+System.currentTimeMillis()+", name="+name);
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            log.info(e.toString());
        }
        return "Hello " + name;
    }
}
