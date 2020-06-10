package cn.cy.system.service;

import java.util.Map;

import com.baomidou.mybatisplus.service.IService;

import cn.cy.system.entity.TSystemUserEntity;

public interface ISystemUserService extends IService<TSystemUserEntity>{

	void addUser(Map<String, Object> map);

	TSystemUserEntity selectEntityByUsername(String username);

}
