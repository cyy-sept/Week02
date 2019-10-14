/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: ReadTest.java 
 * @Prject: cyy-senior2-week2
 * @Package: com.cyy.senior2.week2.test 
 * @Description: TODO
 * @author: 露露先生   
 * @date: 2019年10月14日 上午8:57:30 
 * @version: V1.0   
 */
package com.cyy.senior2.week2.test;

import java.io.File;
import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cyy.common.utils.StreamUtil;
import com.cyy.common.utils.StringUtil;
import com.cyy.senior2.week2.domain.Goods;

/** 
 * @ClassName: ReadTest 
 * @Description: TODO
 * @author: 程远扬
 * @date: 2019年10月14日 上午8:57:30  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:spring-beans.xml")
public class ReadTest {

	@Autowired
	RedisTemplate redisTemplate;
	
	@Test
	public void readList() {
		
		//获取文件
		String string = StreamUtil.readTextFile(new File("src/test/resources/week2.txt"));
		
		String[] split2 = string.split("\\/n");
		
		for (String string2 : split2) {
			
			String[] split = string2.split("\\==");
			for (int i = 0; i < split.length; i++) {
				//System.out.println(split[i]);
				
				Goods goods = new Goods();
				boolean number = StringUtil.isNumber(split[0]);
				if(number) {
					goods.setId(Integer.parseInt(split[0]));
				}
				boolean name = StringUtil.hasText(split[1]);
				if(name) {
					goods.setName(split[1]);
				}
				
				goods.setPrice(null);
				
				boolean cpar = StringUtil.hasText(split[3]);
				if(cpar) {
					goods.setName(split[3]);
				}
				
				System.out.println(goods.toString());
				redisTemplate.opsForList().leftPush("goods_list",goods);
			}
			
		}
		
	}
	
	@Test
	public void readZset() {
		
		//获取文件
		String string = StreamUtil.readTextFile(new File("src/test/resources/week2.txt"));
		
		String[] split2 = string.split("\\/n");
		
		for (String string2 : split2) {
			
			String[] split = string2.split("\\==");
			for (int i = 0; i < split.length; i++) {
				//System.out.println(split[i]);
//				
//				Goods goods = new Goods();
//				goods.setId(Integer.parseInt(split[0]));
//				goods.setName(split[1]);
//				goods.setPrice(null);
//				goods.setCpar(split[3]);
				
				//System.out.println(goods.toString());
				//redisTemplate.opsForZSet().add("goods_zset", goods);
			}
			
		}
		
	}
}
