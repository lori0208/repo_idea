package com.zxz.controller;

import com.github.pagehelper.PageInfo;
import com.zxz.domain.PromotionAd;
import com.zxz.domain.PromotionAdVo;
import com.zxz.domain.ResponseResult;
import com.zxz.service.PromotionAdService;
import com.zxz.utils.UploadImgUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PromotionAdController
 * @Description TODO
 * @Creat 2022-01-04  22:58:18
 */

@RestController
@RequestMapping("/PromotionAd")
public class PromotionAdController {

    @Autowired
    private PromotionAdService promotionAdService;

    @RequestMapping("/findAllPromotionAdByPage")
    public ResponseResult findAllPromotionAdByPage(PromotionAdVo promotionAdVo){

        PageInfo<PromotionAd> pageInfo = promotionAdService.findAllPromotionAd(promotionAdVo);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(pageInfo);

        return responseResult;
    }

    @RequestMapping("/PromotionAdUpload")
    public ResponseResult fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {

        Map map = UploadImgUtils.fileUpload(file, request);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(map);

        return responseResult;
    }

    @RequestMapping("/saveOrUpdatePromotionAd")
    public ResponseResult saveOrUpdatePromotionAd(@RequestBody PromotionAd promotionAd){

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setContent(null);

        if (promotionAd.getId() == null){
            // 新增
            promotionAdService.savePromotionAd(promotionAd);
            responseResult.setMessage("新增成功");
        } else {
            // 修改
            promotionAdService.updatePromotionAd(promotionAd);
            responseResult.setMessage("修改成功");
        }

        return responseResult;
    }

    /*
        根据 id 查询 广告信息
    */
    @RequestMapping("/findPromotionAdById")
    public ResponseResult findPromotionAdById(@RequestParam("id") Integer id){

        PromotionAd promotionAd = promotionAdService.findPromotionAdById(id);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(promotionAd);

        return responseResult;
    }

    /*
        修改广告状态信息
     */
    @RequestMapping("/updatePromotionAdStatus")
    public ResponseResult updatePromotionAdStatus(Integer id, Integer status){

        promotionAdService.updatePromotionAdStatus(id,status);

        Map<String, Object> map = new HashMap<>();
        map.put("status",status);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(map);

        return responseResult;
    }
}
