package com.example.controller;

import com.example.common.config.MyConfig;
import com.example.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @Autowired
    private MyService myService;
    @Autowired
    private MyConfig myConfig;

    @Autowired
    public MyController(MyService myService, MyConfig myConfig) {
        this.myService = myService;
        this.myConfig = myConfig;
    }

    //    @RequestMapping(method = RequestMethod.GET, value = "/test")
//    public String test() {
//        return "test";
//    }
    // 위와 달리 GetMapping을 사용해서 더 깔끔하게 만들 수 있다.
    @GetMapping("/")
    public String get() {
        return "test";
    }

    @PostMapping("/")
    public String create() {
        return "test";
    }

    @PutMapping()
    public String update() {
        return "test";
    }

    @DeleteMapping()
    public String delete() {
        return "test";
    }
//    @Autowired
//    public MyController(MyService myService, MyConfig myConfig) {
//        this.myService = myService;
//        this.myConfig = myConfig;
//    }

}
