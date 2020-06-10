package cn.cy.business.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

import cn.cy.business.entity.TBuyerEntity;
import cn.cy.common.utils.PageUtils;


public interface IBuyService extends IService<TBuyerEntity>{

	PageUtils queryPage(Map<String, Object> params);
}
