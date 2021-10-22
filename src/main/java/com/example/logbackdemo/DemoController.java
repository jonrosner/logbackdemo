package com.example.logbackdemo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@Slf4j
public class DemoController {
    @Value("${spring.application.name}")
    private String name;

    @Value("${spring.build.version}")
    private String version;

    @GetMapping("test")
    public String test() {
        log.info("received test request");
        return String.format("%s - %s", name, version);
    }
}
