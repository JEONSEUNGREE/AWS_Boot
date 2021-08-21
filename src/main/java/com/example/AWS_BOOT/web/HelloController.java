package com.example.AWS_BOOT.web;


import com.example.AWS_BOOT.web.dto.HelloRespnseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        HelloRespnseDto dto = new HelloRespnseDto("hihi", 55);

        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloRespnseDto helloDto(@RequestParam("name") String name,
                                    @RequestParam("amount") int amount) {
        log.info(name + "name");

        return new HelloRespnseDto(name, amount);
    }
}
