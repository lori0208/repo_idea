package com.zxz.dao;

import com.zxz.domain.PromotionSpace;

import java.util.List;

/**
 * @ClassName PromotionSpaceMapper
 * @Description TODO
 * @Creat 2022-01-04  17:35:43
 */
public interface PromotionSpaceMapper {

    /*
        查询所有广告位
     */
    public List<PromotionSpace> findAllPromotionSpace();

    /*
        添加 广告位
     */
    public void savePromotionSpace(PromotionSpace promotionSpace);

    /*
        回显广告位名称，根据 id 查询广告位信息
     */
    public PromotionSpace findPromotionSpaceById(Integer id);

    /*
        修改 广告位
     */
    public void updatePromotionSpace(PromotionSpace promotionSpace);
}
