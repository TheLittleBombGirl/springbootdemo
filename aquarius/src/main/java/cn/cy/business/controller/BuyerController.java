package cn.cy.business.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cy.business.service.IBuyService;
import cn.cy.common.utils.PageUtils;
import cn.cy.common.utils.R;

@Controller
@RequestMapping("buyer")
public class BuyerController {
	
	
	@Autowired
	private IBuyService buyService;
	
	@RequestMapping("/buyerList")
	public String buyerList() {
		
		return "web/page/business/buyerList";
	}

	@ResponseBody
	@RequestMapping(value = "/listData", method = {RequestMethod.POST, RequestMethod.GET})
	public R list(@RequestParam Map<String, Object> params) {
		PageUtils page = buyService.queryPage(params);
		return R.ok().put("page", page.getRows());
	}
}
