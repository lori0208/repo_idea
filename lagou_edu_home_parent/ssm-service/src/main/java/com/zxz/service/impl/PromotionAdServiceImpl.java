package com.zxz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zxz.dao.PromotionAdMapper;
import com.zxz.dao.PromotionSpaceMapper;
import com.zxz.domain.PromotionAd;
import com.zxz.domain.PromotionAdVo;
import com.zxz.service.PromotionAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName PromotionAdServiceImpl
 * @Description TODO
 * @Creat 2022-01-04  22:50:00
 */
@Service
public class PromotionAdServiceImpl implements PromotionAdService {

    @Autowired
    private PromotionAdMapper promotionAdMapper;

    @Override
    public PageInfo<PromotionAd> findAllPromotionAd(PromotionAdVo promotionAdVo) {

        PageHelper.startPage(promotionAdVo.getCurrentPage(),promotionAdVo.getPageSize());
        List<PromotionAd> promotionAdList = promotionAdMapper.findAllPromotionAd();

        PageInfo<PromotionAd> pageInfo = new PageInfo<>(promotionAdList);

        return pageInfo;
    }

    @Override
    public void savePromotionAd(PromotionAd promotionAd) {

        //
        Date date = new Date();
        promotionAd.setCreateTime(date);
        promotionAd.setUpdateTime(date);

        promotionAdMapper.savePromotionAd(promotionAd);

    }

    @Override
    public void updatePromotionAd(PromotionAd promotionAd) {

        //
        Date date = new Date();
        promotionAd.setUpdateTime(date);

        promotionAdMapper.updatePromotionAd(promotionAd);
    }

    @Override
    public PromotionAd findPromotionAdById(Integer id) {

        PromotionAd promotionAd = promotionAdMapper.findPromotionAdById(id);

        return promotionAd;
    }

    @Override
    public void updatePromotionAdStatus(Integer id, Integer status) {

        PromotionAd promotionAd = new PromotionAd();
        promotionAd.setId(id);
        promotionAd.setStatus(status);
        promotionAd.setUpdateTime(new Date());

        promotionAdMapper.updatePromotionAdStatus(promotionAd);
    }
}
