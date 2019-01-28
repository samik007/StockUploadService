package com.home.samik.SpringBootWithAngular.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import com.home.samik.SpringBootWithAngular.entity.StockDetails;

@Component
public class StockDetailsDto {
	private List<StockDetails> listOfStocks;
	private Integer totalStockCount;
	public List<StockDetails> getListOfStocks() {
		return listOfStocks;
	}
	public void setListOfStocks(List<StockDetails> listOfStocks) {
		this.listOfStocks = listOfStocks;
	}
	public Integer getTotalStockCount() {
		return totalStockCount;
	}
	public void setTotalStockCount(Integer totalStockCount) {
		this.totalStockCount = totalStockCount;
	}
}
