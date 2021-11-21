package com.example.demo.controller;

import com.example.demo.model.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * UserController
 *
 * @author jiankang.xu
 * @date 2021/8/28
 */

@RestController
public class HelloController {


    @Autowired
    private Resource resource;

    @RequestMapping("/resource")
    @ResponseBody
    public String getA()
    {
        return resource.getLanguage()+resource.getName()+resource.getPhone();
    }


}
