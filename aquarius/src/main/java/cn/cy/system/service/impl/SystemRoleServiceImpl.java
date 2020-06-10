package cn.cy.system.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import cn.cy.system.dao.ISystemRoleDao;
import cn.cy.system.entity.TSystemRoleEntity;
import cn.cy.system.service.ISystemRoleService;

@Service("iSystemRoleService")
public class SystemRoleServiceImpl extends ServiceImpl<ISystemRoleDao, TSystemRoleEntity> 
implements ISystemRoleService{

}
