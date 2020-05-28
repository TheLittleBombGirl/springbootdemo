package cn.cy.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import cn.cy.system.dao.ISystemMenuDao;
import cn.cy.system.entity.TSystemMenuEntity;
import cn.cy.system.service.ISystemMenuService;

@Service("systemMenuService")
public class SystemMenuServiceImpl extends ServiceImpl<ISystemMenuDao, TSystemMenuEntity> 
implements ISystemMenuService{

	
	
	@Override
	public List<TSystemMenuEntity> getAllMenuList() {
		return baseMapper.getAllMenuList();
	}
	

}
