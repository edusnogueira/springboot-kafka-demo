package com.eduardo.springbootkafkademo.controller.dto;

import java.util.List;

import lombok.Data;

@Data
public class DemoDTO {
    private String name;
    private String age;
    private List<Integer> storesToAccess;
}
/* 
{
    "name": "eduardo",
    "age": "30",
    "stores_to_access" : [1234,1234,4321]
}
 */