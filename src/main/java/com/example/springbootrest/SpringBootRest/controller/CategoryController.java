package com.example.springbootrest.SpringBootRest.controller;


import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CategoryController {


    void test() {

        List<String> list = new ArrayList<String>();
        list.stream()
                .map(productCategory -> productCategory)
                .collect(Collectors.toList());
    }
}
