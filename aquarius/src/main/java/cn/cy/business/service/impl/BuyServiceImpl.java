package cn.cy.business.service.impl;

import java.util.Map;


import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import cn.cy.business.dao.IBuyerDao;
import cn.cy.business.entity.TBuyerEntity;
import cn.cy.business.service.IBuyService;
import cn.cy.common.utils.PageUtils;
import cn.cy.common.utils.Query;

@Service("buyService")
public class BuyServiceImpl extends ServiceImpl<IBuyerDao, TBuyerEntity> implements IBuyService{

	
	@Override
	public PageUtils queryPage(Map<String, Object> params) {
		Page<TBuyerEntity> page = this.selectPage(new Query<TBuyerEntity>(params).getPage(), new EntityWrapper<TBuyerEntity>());
		return new PageUtils(page);
	}


}
