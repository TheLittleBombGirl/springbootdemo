package cn.cy.business.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.cy.business.entity.TBuyerEntity;
import cn.cy.business.service.IBuyService;

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
	public Map<String,Object> listData(@RequestParam Map<String, Object> params){
		Map<String,Object> resultMap = new HashMap<String, Object>();
		List<TBuyerEntity> listData = buyService.queryListData(params);
		resultMap.put("listData", listData);
		return resultMap;
	}
}
