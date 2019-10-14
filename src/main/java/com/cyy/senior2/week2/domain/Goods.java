/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: Goods.java 
 * @Prject: cyy-senior2-week2
 * @Package: com.cyy.senior2.week2.domain 
 * @Description: TODO
 * @author: 露露先生   
 * @date: 2019年10月14日 上午10:12:55 
 * @version: V1.0   
 */
package com.cyy.senior2.week2.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/** 
 * @ClassName: Goods 
 * @Description: TODO
 * @author: 程远扬
 * @date: 2019年10月14日 上午10:12:55  
 */
public class Goods implements Serializable{

	/**
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: TODO
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String name;
	private BigDecimal price;
	private String cpar;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getCpar() {
		return cpar;
	}
	public void setCpar(String cpar) {
		this.cpar = cpar;
	}
	@Override
	public String toString() {
		return "Goods [id=" + id + ", name=" + name + ", price=" + price + ", cpar=" + cpar + "]";
	}
	
	
}
