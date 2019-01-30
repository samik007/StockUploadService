package com.home.samik.SpringBootWithAngular.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.home.samik.SpringBootWithAngular.dto.StockDto;
import com.home.samik.SpringBootWithAngular.entity.StockDetails;

public interface FileService {
	public void uploadFileDataToDB(MultipartFile file) throws Exception;
	public List<StockDetails> getAllStockData(Integer pageIndex, Integer changeNoOfRecords, String orderByCol) throws Exception;
	public List<StockDetails> getDetailsByName(String stockName) throws Exception;
	public List<StockDetails> getDetailsByPerformance();
	public Integer getTotalNoOfStock();
	public Integer deleteStockById(Integer id) throws Exception;
	public Integer duplicateStock(StockDto stockDto) throws Exception;
	public Integer saveStock(StockDto stockDto) throws Exception;
	public Integer editStock(Integer id, StockDto stockDto) throws Exception;
}
