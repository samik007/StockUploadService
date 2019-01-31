package com.home.samik.SpringBootWithAngular.dto;

import org.springframework.stereotype.Component;

@Component
public class HighGraphDto {
	private String stockCompanyName;
	private Integer totalHigh;
	public String getStockCompanyName() {
		return stockCompanyName;
	}
	public void setStockCompanyName(String stockCompanyName) {
		this.stockCompanyName = stockCompanyName;
	}
	public Integer getTotalHigh() {
		return totalHigh;
	}
	public void setTotalHigh(Integer totalHigh) {
		this.totalHigh = totalHigh;
	}
}
	