package com.home.samik.SpringBootWithAngular.dto;

public class LowGraphDto {
	private String stockCompanyName;
	private Integer totalLow;
	public String getStockCompanyName() {
		return stockCompanyName;
	}
	public void setStockCompanyName(String stockCompanyName) {
		this.stockCompanyName = stockCompanyName;
	}
	public Integer getTotalLow() {
		return totalLow;
	}
	public void setTotalLow(Integer totalLow) {
		this.totalLow = totalLow;
	}
}
