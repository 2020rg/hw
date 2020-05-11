package com.ssrg.hw.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/session")
public class SessionController {

    @RequestMapping("/getSession")
    public Map<String,Object> getSession(HttpServletRequest request){
        Map<String,Object> result = new HashMap<>();

        result.put("studentId",request.getSession().getAttribute("studentId"));

        return result;
    }
}
