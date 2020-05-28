package cn.cy.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("seller")
public class SellerController {
	
	@RequestMapping("/sellerList")
	public String sellerList() {
		
		return "web/page/business/sellerList";
	}

}
