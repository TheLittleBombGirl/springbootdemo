package cn.cy.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.cy.common.utils.RedisUtils;
import cn.cy.system.entity.TSystemUserEntity;
import cn.cy.system.service.ISystemUserService;

@Controller
public class SysPageController {
	@Autowired
    private RedisUtils redisUtils;
	
	@Autowired
	private ISystemUserService iSystemUserService;
	
	@RequestMapping("/main.html")
	public String main(HttpServletRequest request) {
		String password = redisUtils.get("password");
		if(password != null && password.length() != 0) {
			request.setAttribute("password", password);
		}else {
			TSystemUserEntity systemUserEntity = iSystemUserService.selectEntityByUsername("super");
			redisUtils.set("password", systemUserEntity.getPassword());
			request.setAttribute("password", systemUserEntity.getPassword());
		}
		return "web/page/main/main";
	}
	
	@RequestMapping("/homePage.html")
	public String homePage(HttpServletRequest request) {
		return "web/page/main/homePage";
	}
}
