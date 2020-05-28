package cn.cy.business.dao;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import cn.cy.business.entity.TBuyerEntity;

public interface IBuyerDao extends BaseMapper<TBuyerEntity>{

	List<TBuyerEntity> queryListData(Map<String, Object> params);

}
