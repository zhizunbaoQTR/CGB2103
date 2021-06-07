package com.jt.springboot_demo_1.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@PropertySource(value = "classpath:/properties/hello.properties",encoding = "utf-8")
public class HelloController {
@Value("${hello.msg}")
    private String msg;
@Value("${jt.msg}")
    private String msg2;
@GetMapping("/hello")
public String hello(){
    return msg+"|"+msg2;
}
}
