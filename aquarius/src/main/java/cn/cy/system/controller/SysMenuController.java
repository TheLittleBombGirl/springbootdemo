package cn.cy.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.cy.common.utils.R;
import cn.cy.system.entity.TSystemMenuEntity;
import cn.cy.system.service.ISystemMenuService;

/**
 * 菜单管理
 * @author yun
 *
 */
@RestController
@RequestMapping("sysMenu")
public class SysMenuController {
	
	@Autowired
	private ISystemMenuService systemMenuService;
	
	@RequestMapping(value = "/getMenu", method = {RequestMethod.POST, RequestMethod.GET})
	public R getMenu() {
		List<TSystemMenuEntity> menuList = systemMenuService.getAllMenuList();
		return R.ok().put("menuList", menuList);
	}
}
