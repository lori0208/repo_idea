package com.zxz.service;

import com.github.pagehelper.PageInfo;
import com.zxz.domain.PromotionAd;
import com.zxz.domain.PromotionAdVo;

import java.util.List;

/**
 * @ClassName PromotionAdService
 * @Description TODO
 * @Creat 2022-01-04  22:49:32
 */
public interface PromotionAdService {

    /*
        查询所有广告信息以及关联的广告位
     */
    public PageInfo<PromotionAd> findAllPromotionAd(PromotionAdVo promotionAdVo);


    /*
        新建广告
     */
    public void savePromotionAd(PromotionAd promotionAd);

    /*
        修改广告
     */
    public void updatePromotionAd(PromotionAd promotionAd);

    /*
        根据 id 查询 广告信息
     */
    public PromotionAd findPromotionAdById(Integer id);

    /*
        修改广告状态信息
     */
    public void updatePromotionAdStatus(Integer id, Integer status);
}
