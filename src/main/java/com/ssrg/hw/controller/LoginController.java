package com.ssrg.hw.controller;

import com.ssrg.hw.dto.StudentDto;
import com.ssrg.hw.dto.TeacherDto;
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
        Integer flag = -2;

        if(request.getSession().getAttribute("userId") != null){
            flag = -3;   //重复登录
            map.put("flag",flag);
            return map;
        }

        if(role.equals("student")){
            StudentDto studentDto = studentService.queryStudentByPhone(phone);
            if (studentDto != null) {
                if (password.equals(studentDto.getPassword())) {
                    flag = 0;
                    //登陆成功
                    map.put("studentId", studentDto.getStudentId());

                    request.getSession().setAttribute("userId", studentDto.getStudentId());
                    request.getSession().setAttribute("name", studentDto.getName());
                    request.getSession().setAttribute("school", studentDto.getSchool());
                    request.getSession().setAttribute("phone", studentDto.getPhone());
                    request.getSession().setAttribute("enterSchoolYear", studentDto.getEnterSchoolYear());

                } else {
                    flag = -1;
                    //登录密码不正确
                }
            } else {
                flag = -2;
                //此账号不存在
            }
        }
        else if(role.equals("teacher")){
            TeacherDto teacherDto = teacherService.queryTeacherByPhone(phone);
            if(teacherDto != null){
                if(password.equals(teacherDto.getPassword())){
                    flag = 0;
                    map.put("teacherId",teacherDto.getTeacherId());

                    request.getSession().setAttribute("userId", teacherDto.getTeacherId());
                    request.getSession().setAttribute("name", teacherDto.getName());
                    request.getSession().setAttribute("school", teacherDto.getSchool());
                    request.getSession().setAttribute("phone", teacherDto.getPhone());
                }
                else{
                    flag = -1;
                }
            }
            else{
                flag = -2;
            }

        }

        map.put("flag", flag);
        return map;
    }

    @RequestMapping("/signup")
    public Map<String,Object> signup(
            @RequestParam("username") String name,
            @RequestParam("cellphone") int phone,
            @RequestParam("password") String password,
            @RequestParam("role") String role,
            HttpServletRequest request
    ){
        Map<String,Object> result = new HashMap<>();
        int flag = 0;
        if(role.equals("student")){
            if(studentService.queryStudentByPhone(phone) == null){
                StudentDto studentDto = new StudentDto();
                studentDto.setName(name);
                studentDto.setPhone(phone);
                studentDto.setPassword(password);
                studentService.addStudent(studentDto);
            }
            else{
                flag = -1;   //手机号已被使用
                result.put("flag",flag);
                return result;
            }
        }
        else if(role.equals("teacher")){
            if(teacherService.queryTeacherByPhone(phone) == null){
                TeacherDto teacherDto = new TeacherDto();
                teacherDto.setName(name);
                teacherDto.setPhone(phone);
                teacherDto.setPassword(password);
                teacherService.addTeacher(teacherDto);
            }
            else{
                flag = -1;   //手机号已被使用
                result.put("flag",flag);
                return result;
            }
        }

        result.put("flag",flag);
        return result;
    }
}
