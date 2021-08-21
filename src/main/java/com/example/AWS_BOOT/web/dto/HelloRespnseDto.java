package com.example.AWS_BOOT.web.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class HelloRespnseDto {

    private final String name;
    private final int amount;

}
