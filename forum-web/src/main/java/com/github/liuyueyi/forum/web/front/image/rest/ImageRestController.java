package com.github.liuyueyi.forum.web.front.image.rest;

import com.github.liueyueyi.forum.api.model.vo.ResVo;
import com.github.liuyueyi.forum.service.image.service.ImageServiceImpl;
import com.github.liuyueyi.forum.web.front.image.vo.ImageVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 返回json格式数据
 *
 * @author LouZai
 * @date 2022/9/7
 */
@RequestMapping(path = "image/")
@RestController
@Slf4j
public class ImageRestController {

    @Autowired
    private ImageServiceImpl imageServiceImpl;

    /**
     * 图片上传
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(path = "upload")
    public ResVo<ImageVo> upload(HttpServletRequest request) {
        ImageVo imageVo = new ImageVo();
        try {
            String imagePath = imageServiceImpl.saveImg(request);
            imageVo.setImagePath(imagePath);
        } catch (Exception e) {
            log.error("save upload file error!", e);
        }
        return ResVo.ok(imageVo);
    }
}