package cn.cy.system.dao;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;

import cn.cy.system.entity.TSystemMenuEntity;

public interface ISystemMenuDao extends BaseMapper<TSystemMenuEntity>{

	List<TSystemMenuEntity> getAllMenuList();

}
