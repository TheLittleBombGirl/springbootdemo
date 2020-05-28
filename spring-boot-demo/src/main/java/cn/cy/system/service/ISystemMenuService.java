package cn.cy.system.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;

import cn.cy.system.entity.TSystemMenuEntity;

public interface ISystemMenuService extends IService<TSystemMenuEntity>{

	List<TSystemMenuEntity> getAllMenuList();

}
