package cn.cy.business.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import cn.cy.business.dao.IBuyerDao;
import cn.cy.business.entity.TBuyerEntity;
import cn.cy.business.service.IBuyService;

@Service("buyService")
public class BuyServiceImpl extends ServiceImpl<IBuyerDao, TBuyerEntity> implements IBuyService{

	@Override
	public List<TBuyerEntity> queryListData(Map<String, Object> params) {
		return baseMapper.queryListData(params);
	}

}
