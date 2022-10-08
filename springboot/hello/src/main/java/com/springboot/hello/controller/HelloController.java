package com.springboot.hello.controller;

import ch.qos.logback.classic.Logger;
import com.springboot.hello.dto.MemberDto;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Member;
import java.util.Map;

@RestController
public class HelloController {

    private final Logger LOGGER = (Logger) LoggerFactory.getLogger(GetController.class);

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        LOGGER.info("getHello 메서드가 호출되었습니다.");
        return "Hello World!";
    }

    @GetMapping(value = "/name")
    public String getName(){
        LOGGER.info("getHello 메서드가 호출되었습니다.");
        return "Flasture";
    }

    @GetMapping(value = "/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }

    @GetMapping(value = "/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }

}
