package com.demo.api.service;

import com.demo.api.domain.Business;
import com.demo.api.persistence.BusinessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class BusinessService {

    private final BusinessRepository businessRepository;

    public Integer businessCreate(Business business){
        Integer id = businessRepository.create(business);
        return id;
    }

    public Business businessDetail(Integer id){
        return businessRepository.findById(id);
    }

    public boolean businessDelete(Integer id){
        return businessRepository.delete(id);
    }

    public boolean businessUpdate(Business business){
        return businessRepository.update(business);
    }
}
