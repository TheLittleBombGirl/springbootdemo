package cn.cy.system.dao;

import java.util.Map;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import cn.cy.system.entity.TSystemUserEntity;

public interface ISystemUserDao extends BaseMapper<TSystemUserEntity>{

	void addUser(Map<String, Object> map);

	TSystemUserEntity selectEntityByUsername(String username);

}
