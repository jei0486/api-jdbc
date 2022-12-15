package com.demo.api.controller;

import com.demo.api.domain.Business;
import com.demo.api.service.BusinessService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/business")
@RequiredArgsConstructor
@RestController
public class BusinessController {

    private final BusinessService businessService;

    @PostMapping("")
    private Integer businessCreate(@RequestBody Business business){
        return businessService.businessCreate(business);
    }

    @GetMapping("/{id}")
    private Business businessDetail(@PathVariable Integer id){
        return businessService.businessDetail(id);
    }

    @DeleteMapping("/{id}")
    private boolean businessDelete(@PathVariable Integer id){
        return businessService.businessDelete(id);
    }

    @PutMapping("")
    private boolean businessUpdate(@RequestBody Business business){
        return businessService.businessUpdate(business);
    }
}
