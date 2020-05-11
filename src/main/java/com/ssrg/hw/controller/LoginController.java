package com.ssrg.hw.controller;

import com.ssrg.hw.dto.StudentDto;
import com.ssrg.hw.service.IStudentService;
import com.ssrg.hw.service.ITeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private ITeacherService teacherService;

    @RequestMapping("/userLogin")
    public Map<String, Object> studentLogin(@RequestParam("phone") int phone, @RequestParam("password") String password, @RequestParam("role") String role, HttpServletRequest request){
        Map<String, Object> map = new HashMap<String, Object>();
        Integer flag = 1;

        if(role.equals("student")){
            StudentDto studentDto = studentService.queryStudentByPhone(phone);
            if (studentDto != null) {
                if (password.equals(studentDto.getPassword())) {
                    flag = 0;
                    //登陆成功
                    map.put("studentID", studentDto.getStudentId());

                    request.getSession().setAttribute("userID", studentDto.getStudentId());
                    request.getSession().setAttribute("name", studentDto.getName());
                    request.getSession().setAttribute("school", studentDto.getSchool());
                    request.getSession().setAttribute("phone", studentDto.getPhone());
                    request.getSession().setAttribute("enterSchoolYear", studentDto.getEnterSchoolYear());

                } else {
                    flag = 1;
                    //登录密码不正确
                }
            } else {
                flag = 2;
                //此账号不存在
            }
        }
        else if(role.equals("teacher")){

        }

        map.put("flag", flag);
        return map;
    }
}
