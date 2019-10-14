/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: GoodsController.java 
 * @Prject: cyy-senior2-week2
 * @Package: com.cyy.senior2.week2.controller 
 * @Description: TODO
 * @author: 露露先生   
 * @date: 2019年10月14日 上午9:27:28 
 * @version: V1.0   
 */
package com.cyy.senior2.week2.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cyy.senior2.week2.domain.Goods;


/** 
 * @ClassName: GoodsController 
 * @Description: TODO
 * @author: 程远扬
 * @date: 2019年10月14日 上午9:27:28  
 */
@Controller
public class GoodsController {

	@Autowired
	RedisTemplate redisTemplate;
	
	@RequestMapping("list")
	public String list(Model model,
				@RequestParam(defaultValue="1")Integer page,
				@RequestParam(defaultValue="10")Integer pageSize
			) {
		
		List<Goods> list = redisTemplate.opsForList().range("goods_list", (page-1)*pageSize, (page-1)*pageSize+pageSize-1);
		
		model.addAttribute("list", list);
		
		if(page!=1) {
			model.addAttribute("prePage", page-1);
		}else {
			model.addAttribute("prePage", 1);
		}
		
		model.addAttribute("nextPage", page+1);
		
				return "list";
	}
	
	
	@RequestMapping("Zset")
	public String Zset(Model model,
				@RequestParam(defaultValue="1")Integer page,
				@RequestParam(defaultValue="10")Integer pageSize
			) {
		
		Set list = redisTemplate.opsForZSet().reverseRange("goods_zset", (page-1)*pageSize, (page-1)*pageSize+pageSize-1);
		
		model.addAttribute("list", list);
		
		if(page!=1) {
			model.addAttribute("prePage", page-1);
		}else {
			model.addAttribute("prePage", 1);
		}
		
		model.addAttribute("nextPage", page+1);
		
				return "listZset";
	}
}
