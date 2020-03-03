package com.zb.consumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClientService {

    @Autowired
    RestTemplate restTemplate;

    public String buy(){
        return restTemplate.getForObject("http://SERVICE-PROVIDER/go",String.class);
    }

}
