package com.eduardo.springbootkafkademo.domain.model;

import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DemoObject {
    private String name;
    private String age;
    private Set<Integer> storesToAccess;    
}
