package com.atguigu.admin.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @date:2022/2/26 删除选中行ctrl+y 向下复制ctrl+d 代码自动生成alt+ins 调整代码格式ctrl+alt+l 多行缩进tab  抛异常ctrl+alt+t
 */
@Slf4j
@Controller
public class FormTestController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }
    @PostMapping("/upload")
    public String upload(@RequestParam("email")String email,
                         @RequestParam("userName")String userName,
                         @RequestPart("headerImg")MultipartFile headerImg,
                         @RequestPart("photos")MultipartFile[] photos) throws IOException {
                            //MultipartFile:自动封装上传过来的文件
        log.info("上传的信息:email={},userName={},headerImg={},photos={}",
                email,userName,headerImg.getSize(),photos.length);
        if (!headerImg.isEmpty()){
            //保存到文件服务器
            String originalFilename = headerImg.getOriginalFilename();
            UUID uuid = UUID.randomUUID();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String format = simpleDateFormat.format(new Date());
            headerImg.transferTo(new File("D:\\picture\\"+uuid+format+originalFilename));
        }
        if (photos.length>0){
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    UUID uuid = UUID.randomUUID();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS");
                    String format = simpleDateFormat.format(new Date());
                    photo.transferTo(new File("D:\\picture\\"+uuid+format+originalFilename));
                }
            }
        }
        return "main";
    }
}
