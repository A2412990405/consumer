package com.zb.consumer.controller;

import com.zb.consumer.service.ClientService;
import com.zb.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.util.Map;

@Controller
public class clientController {

    //@Autowired
    //ClientService clientService;

    @Autowired
    UserService userService;

    @Autowired
    ServletContext servletContext;

//    @RequestMapping("/shopping")
//    public String buy(){
//        return clientService.buy();
//    }

    @RequestMapping("/all")
    public String search(Model model,@RequestParam Map map){
        System.out.println("来了一句代码");
        System.out.println("consumer:"+map);
        model.addAttribute("users", userService.getAll(map));
        return "list";
    }


    @RequestMapping("/add")
    public String tiao(){
        return "add";
    }

    @PostConstruct
    public  void getRole(){
        servletContext.setAttribute("roles",userService.getRole());
    }

    @RequestMapping("/jia")
    public String add(@RequestParam Map map){
        System.out.println("map:"+map);
        int count = userService.add(map);
        System.out.println(count);
        return "redirect:/all";
    }









}
