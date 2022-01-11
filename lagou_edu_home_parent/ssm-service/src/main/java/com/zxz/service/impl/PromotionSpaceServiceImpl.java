package com.zxz.service.impl;

import com.zxz.dao.PromotionSpaceMapper;
import com.zxz.domain.PromotionSpace;
import com.zxz.service.PromotionSpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName PromotionSpaceServiceImpl
 * @Description TODO
 * @Creat 2022-01-04  17:39:08
 */

@Service
public class PromotionSpaceServiceImpl implements PromotionSpaceService {

    @Autowired
    private PromotionSpaceMapper promotionSpaceMapper;

    @Override
    public List<PromotionSpace> findAllPromotionSpace() {

        List<PromotionSpace> promotionSpaceList = promotionSpaceMapper.findAllPromotionSpace();

        return promotionSpaceList;
    }

    @Override
    public void savePromotionSpace(PromotionSpace promotionSpace) {

        // 补全信息
        promotionSpace.setSpaceKey(UUID.randomUUID().toString());
        Date date = new Date();
        promotionSpace.setCreateTime(date);
        promotionSpace.setUpdateTime(date);
        promotionSpace.setIsDel(0);

        // 调用 mapper 方法
        promotionSpaceMapper.savePromotionSpace(promotionSpace);
    }

    @Override
    public PromotionSpace findPromotionSpaceById(Integer id) {

        PromotionSpace promotionSpace = promotionSpaceMapper.findPromotionSpaceById(id);

        return promotionSpace;
    }

    @Override
    public void updatePromotionSpace(PromotionSpace promotionSpace) {

        // 补全信息
        promotionSpace.setUpdateTime(new Date());

        promotionSpaceMapper.updatePromotionSpace(promotionSpace);
    }
}
