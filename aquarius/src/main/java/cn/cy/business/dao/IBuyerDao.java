package cn.cy.business.dao;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import cn.cy.business.entity.TBuyerEntity;
import cn.cy.common.utils.PageUtils;

public interface IBuyerDao extends BaseMapper<TBuyerEntity>{


	PageUtils queryPage(Map<String, Object> params);

}
