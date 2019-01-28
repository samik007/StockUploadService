package com.home.samik.SpringBootWithAngular.dao;

import java.util.List;

import com.home.samik.SpringBootWithAngular.entity.StockDetails;

public interface FileDao {
	public void uploadFileDataToDB(List<StockDetails> listOfStocks) throws Exception;
	public List<StockDetails> getAllStockData(Integer pageIndex, Integer changeNoOfRecords, String orderByCol) throws Exception;
	public List<StockDetails> getDetailsByName(String stockName) throws Exception;
	public List<StockDetails> getDetailsByPerformance();
	public Integer getTotalNoOfStock();
}
