package cn.cy.system.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import cn.cy.system.dao.ISystemUserRoleDao;
import cn.cy.system.entity.TSystemUserRoleEntity;
import cn.cy.system.service.ISystemUserRoleService;

@Service("iSystemUserRoleService")
public class SystemUserRoleServiceImpl extends ServiceImpl<ISystemUserRoleDao, TSystemUserRoleEntity> 
implements ISystemUserRoleService{

}
