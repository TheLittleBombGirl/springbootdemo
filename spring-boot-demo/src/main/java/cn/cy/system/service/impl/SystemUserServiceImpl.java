package cn.cy.system.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import cn.cy.system.dao.ISystemUserDao;
import cn.cy.system.entity.TSystemUserEntity;
import cn.cy.system.service.ISystemUserService;

@Service("iSystemUserService")
public class SystemUserServiceImpl extends ServiceImpl<ISystemUserDao, TSystemUserEntity> implements ISystemUserService{
	
	
	@Override
	public void addUser(Map<String, Object> map) {
		baseMapper.addUser(map);
	}

	@Override
	public TSystemUserEntity selectEntityByUsername(String username) {
		return baseMapper.selectEntityByUsername(username);
	}

}
