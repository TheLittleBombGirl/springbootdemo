package cn.cy.business.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

import cn.cy.business.entity.TBuyerEntity;


public interface IBuyService extends IService<TBuyerEntity>{

	List<TBuyerEntity> queryListData(Map<String, Object> params);

}
