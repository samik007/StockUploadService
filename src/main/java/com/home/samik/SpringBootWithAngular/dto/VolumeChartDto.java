package com.home.samik.SpringBootWithAngular.dto;

import org.springframework.stereotype.Component;

@Component
public class VolumeChartDto {
	private String stockCompanyName;
	private Integer count;
	public String getStockCompanyName() {
		return stockCompanyName;
	}
	public void setStockCompanyName(String stockCompanyName) {
		this.stockCompanyName = stockCompanyName;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
}
