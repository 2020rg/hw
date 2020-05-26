package com.ssrg.hw.controller;

import com.ssrg.hw.dto.CourseDto;
import com.ssrg.hw.dto.CourseResourceDto;
import com.ssrg.hw.service.ICourseResourceService;
import com.ssrg.hw.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resource")
public class CourseResourceController {

    @Autowired
    private ICourseResourceService courseResourceService;

    @Autowired
    private ICourseService courseService;

    @RequestMapping("/queryCourseResourceByCourseId")
    public List<CourseResourceDto> queryCourseResourceByCourseId(int courseId)
    {
        List<CourseResourceDto> courseResourceList=courseResourceService.queryCourseResourceByCourseId(courseId);
        return courseResourceList;
    }


    @RequestMapping("/queryCourseResourceByResourceId")
    public CourseResourceDto queryCourseResourceByResourceId(int resourceId)
    {
        CourseResourceDto courseResourceDto=courseResourceService.queryCourseResourceByResourceId(resourceId);
        return courseResourceDto;
    }

    @RequestMapping("/addCourseResource")
    public Map<String,Object> addCourseResource(@RequestParam("courseID") int courseId,
                                 @RequestParam("resourceName") String resourceName,
                                 @RequestParam("resourceFilepath") String resourceFilepath)
    {
        Map<String,Object> map = new HashMap<>();
        int flag;
        CourseDto courseDto = courseService.queryCourseByCourseId(courseId);
        if(courseDto == null){
            flag = 0;
            map.put("flag",flag);
            return map;
        }

        CourseResourceDto courseResourceDto = new CourseResourceDto();
        courseResourceDto.setCourseId(courseId);
        courseResourceDto.setResourceName(resourceName);
        courseResourceDto.setResourceFilepath(resourceFilepath);
        flag = courseResourceService.addCourseResource(courseResourceDto);
        map.put("flag",flag);
        return map;
    }

    @RequestMapping("/updateCourseResource")
    public int updateCourseResource(CourseResourceDto courseResourceDto)
    {
        courseResourceService.updateCourseResource(courseResourceDto);
        return 1;
    }

    @RequestMapping("/deleteCourseResource")
    public Map<String,Object> deleteCourseResource(@RequestParam("resourceID") int resourceId)
    {
        Map<String,Object> result = new HashMap<>();
        int flag = 0;
        flag = courseResourceService.deleteCourseResource(resourceId);
        result.put("flag",flag);
        return result;
    }

    @RequestMapping("/fileUpload")
    @ResponseBody
    public Map<String,Object> fileUpload(@RequestParam("file")MultipartFile file, @RequestParam("courseID") int courseId){
        Map<String,Object> result = new HashMap<>();
        int flag = 0;

        if(file.isEmpty()){
            flag = 0;
            result.put("flag",flag);
            return result;
        }
        String fileName = file.getOriginalFilename();

        String path = "E:/resource/course/" + courseId;
        File dest = new File(path + "/" + fileName);
        if(!dest.getParentFile().exists()){ //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest); //保存文件
            flag = 1;
            result.put("flag",flag);
            return result;
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            flag = 0;
            result.put("flag",flag);
            e.printStackTrace();
            return result;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            flag = 0;
            result.put("flag",flag);
            e.printStackTrace();
            return result;
        }
    }

    @RequestMapping("/download")
    public Map<String,Object> downLoad(@RequestParam("resourceID")int resourceID, HttpServletResponse response) throws UnsupportedEncodingException {
        Map<String,Object> result = new HashMap<>();
        int flag = 1;
        CourseResourceDto r = courseResourceService.queryCourseResourceByResourceId(resourceID);
        String filename = r.getResourceFilepath();

        String filePath = "E:/resource/course/" + r.getCourseId();
        File file = new File(filePath + "/" + filename);
        if(file.exists()){ //判断文件父目录是否存在
            response.setContentType("application/vnd.ms-excel;charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            // response.setContentType("application/force-download");
            response.setHeader("Content-Disposition", "attachment;fileName=" +   java.net.URLEncoder.encode(filename,"UTF-8"));
            byte[] buffer = new byte[1024];
            FileInputStream fis = null; //文件输入流
            BufferedInputStream bis = null;

            OutputStream os = null; //输出流
            try {
                os = response.getOutputStream();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }

            } catch (Exception e) {
                // TODO Auto-generated catch block
                flag = 0;
                e.printStackTrace();
            }
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                flag = 0;
                e.printStackTrace();
            }
        }
        result.put("flag",flag);
        return result;
    }
}
