package cn.cy.system.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import cn.cy.system.dao.ISystemRoleMenuDao;
import cn.cy.system.entity.TSystemRoleMenuEntity;
import cn.cy.system.service.ISystemRoleMenuService;

@Service("iSystemRoleMenuService")
public class SystemRoleMenuServiceImpl extends ServiceImpl<ISystemRoleMenuDao, TSystemRoleMenuEntity> 
implements ISystemRoleMenuService{

}
