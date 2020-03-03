package com.zb.consumer.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(value = "SERVICE-PROVIDER")
public interface UserService {

    @RequestMapping("/all")
    public List<Map> getAll(@RequestParam Map map);

    @RequestMapping("/AllRole")
    public List<Map> getRole();

    @RequestMapping("/jia")
    public int add(@RequestParam Map map);

}
