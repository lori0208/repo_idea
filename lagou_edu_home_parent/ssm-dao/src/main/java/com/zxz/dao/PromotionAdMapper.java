package com.zxz.dao;

import com.zxz.domain.PromotionAd;

import java.util.List;

/**
 * @ClassName PromotionAdMapper
 * @Description TODO
 * @Creat 2022-01-04  19:04:15
 */
public interface PromotionAdMapper {

    /*
        查询所有广告信息以及关联的广告位
     */
    public List<PromotionAd> findAllPromotionAd();


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
    public void updatePromotionAdStatus(PromotionAd promotionAd);


}
