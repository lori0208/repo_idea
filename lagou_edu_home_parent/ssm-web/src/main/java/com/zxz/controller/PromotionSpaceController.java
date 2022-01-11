package com.zxz.controller;

import com.zxz.domain.PromotionSpace;
import com.zxz.domain.ResponseResult;
import com.zxz.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName PromotionSpaceController
 * @Description TODO
 * @Creat 2022-01-04  17:40:43
 */
@RestController
@RequestMapping("/PromotionSpace")
public class PromotionSpaceController {

    @Autowired
    private PromotionSpaceService promotionSpaceService;

    /*
        查询所有广告位
    */
    @RequestMapping("/findAllPromotionSpace")
    public ResponseResult findAllPromotionSpace(){

        List<PromotionSpace> promotionSpaceList = promotionSpaceService.findAllPromotionSpace();

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(promotionSpaceList);

        return responseResult;
    }

    /*
        添加,修改 广告位
     */
    @RequestMapping("/saveOrUpdatePromotionSpace")
    public ResponseResult saveOrUpdatePromotionSpace(@RequestBody PromotionSpace promotionSpace){

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);

        if (promotionSpace.getId() != null){
            // 修改
            promotionSpaceService.updatePromotionSpace(promotionSpace);
            responseResult.setMessage("修改成功");
        } else {
            // 新增
            promotionSpaceService.savePromotionSpace(promotionSpace);
            responseResult.setMessage("新增成功");
        }
        responseResult.setContent(null);

        return responseResult;
    }

    /*
        回显广告位名称，根据 id 查询广告位信息
     */
    @RequestMapping("/findPromotionSpaceById")
    public ResponseResult findPromotionSpaceById(Integer id){

        PromotionSpace promotionSpace = promotionSpaceService.findPromotionSpaceById(id);

        ResponseResult responseResult = new ResponseResult();
        responseResult.setSuccess(true);
        responseResult.setState(200);
        responseResult.setMessage("请求成功");
        responseResult.setContent(promotionSpace);

        return responseResult;
    }
}
