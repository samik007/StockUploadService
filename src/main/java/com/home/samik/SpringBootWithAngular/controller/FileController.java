package com.home.samik.SpringBootWithAngular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.home.samik.SpringBootWithAngular.dto.ResponseDto;
import com.home.samik.SpringBootWithAngular.dto.StockDetailsDto;
import com.home.samik.SpringBootWithAngular.dto.StockDto;
import com.home.samik.SpringBootWithAngular.entity.StockDetails;
import com.home.samik.SpringBootWithAngular.service.FileService;
import com.home.samik.SpringBootWithAngular.util.StockConstantFile;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class FileController {

	@Autowired
	private ResponseDto responseDto;

	@Autowired
	private FileService fileService;

	@Autowired
	private StockDetailsDto stockDetailsDto;

	@PostMapping("/uploadFile")
	public ResponseEntity<ResponseDto> uploadFile(@RequestPart(value = "file") MultipartFile file) throws Exception {
		try {
			fileService.uploadFileDataToDB(file);
			responseDto.setResponseCode(HttpStatus.OK);
			responseDto.setResponseMessage(StockConstantFile.STOCK_SUCCESS);
			responseDto.setData((Object) null);
		} catch (Exception ex) {
			responseDto.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
			responseDto.setResponseMessage(StockConstantFile.INTERNAL_SERVER_ERROR);
			responseDto.setData((Object) ex);
		}
		return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
	}

	@GetMapping("/AllStockData")
	public ResponseEntity<ResponseDto> getAllStockData(@RequestParam("pageIndex") Integer pageIndex,
			@RequestParam("changeNoOfRecords") Integer changeNoOfRecords,
			@RequestParam("orderByCol") String orderByCol) throws Exception {
		try {
			List<StockDetails> list = fileService.getAllStockData(pageIndex, changeNoOfRecords, orderByCol);
			Integer count = fileService.getTotalNoOfStock();
			stockDetailsDto.setListOfStocks(list);
			stockDetailsDto.setTotalStockCount(count);
			responseDto.setResponseCode(HttpStatus.OK);
			responseDto.setResponseMessage(StockConstantFile.STOCK_SUCCESS);
			responseDto.setData((Object) stockDetailsDto);
		} catch (Exception ex) {
			responseDto.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
			responseDto.setResponseMessage(StockConstantFile.INTERNAL_SERVER_ERROR);
			responseDto.setData((Object) ex);
		}
		return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
	}

	@GetMapping("/allDataByName")
	public ResponseEntity<ResponseDto> getDetailsByName(@RequestParam("stockName") String stockName) throws Exception {
		try {
			List<StockDetails> list = fileService.getDetailsByName(stockName);
			responseDto.setResponseCode(HttpStatus.OK);
			responseDto.setResponseMessage(StockConstantFile.STOCK_SUCCESS);
			responseDto.setData((Object) list);
		} catch (Exception ex) {
			responseDto.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
			responseDto.setResponseMessage(StockConstantFile.INTERNAL_SERVER_ERROR);
			responseDto.setData((Object) ex);
		}
		return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
	}

	@GetMapping("/allDataByPerformance")
	public ResponseEntity<ResponseDto> getDetailsByPerformance() throws Exception {
		try {
			List<StockDetails> list = fileService.getDetailsByPerformance();
			responseDto.setResponseCode(HttpStatus.OK);
			responseDto.setResponseMessage(StockConstantFile.STOCK_SUCCESS);
			responseDto.setData((Object) list);
		} catch (Exception ex) {
			responseDto.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
			responseDto.setResponseMessage(StockConstantFile.INTERNAL_SERVER_ERROR);
			responseDto.setData((Object) ex);
		}
		return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
	}
	
	@DeleteMapping("/deleteStockById/{id}")
	public ResponseEntity<ResponseDto> deleteStockById(@PathVariable("id") Integer id) throws Exception {
		Integer status = 0;
		try {
			status = fileService.deleteStockById(id);
			if (status > 0) {
				responseDto.setResponseCode(HttpStatus.ACCEPTED);
				responseDto.setResponseMessage(StockConstantFile.STOCK_SUCCESS);
				responseDto.setData((Object) status);
			} else {
				responseDto.setResponseCode(HttpStatus.NO_CONTENT);
				responseDto.setResponseMessage(StockConstantFile.NO_CONTENT);
				responseDto.setData((Object) status);
			}
		} catch (Exception ex) {
			responseDto.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
			responseDto.setResponseMessage(StockConstantFile.INTERNAL_SERVER_ERROR);
			responseDto.setData((Object) ex);
		}
		return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
	}
	
	@PostMapping("/duplicateStock")
	public ResponseEntity<ResponseDto> duplicateStock(@RequestBody StockDto stockDto) throws Exception {
		Integer status = 0;
		try {
			status = fileService.duplicateStock(stockDto);
			if (status > 0) {
				responseDto.setResponseCode(HttpStatus.ACCEPTED);
				responseDto.setResponseMessage(StockConstantFile.STOCK_SUCCESS);
				responseDto.setData((Object) status);
			} else {
				responseDto.setResponseCode(HttpStatus.NO_CONTENT);
				responseDto.setResponseMessage(StockConstantFile.NO_CONTENT);
				responseDto.setData((Object) status);
			}
		} catch (Exception ex) {
			responseDto.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
			responseDto.setResponseMessage(StockConstantFile.INTERNAL_SERVER_ERROR);
			responseDto.setData((Object) ex);
		}
		return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
	}
	
	@PostMapping("/saveStock")
	public ResponseEntity<ResponseDto> saveStock(@RequestBody StockDto stockDto) throws Exception {
		Integer status = 0;
		try {
			status = fileService.saveStock(stockDto);
			if (status > 0) {
				responseDto.setResponseCode(HttpStatus.ACCEPTED);
				responseDto.setResponseMessage(StockConstantFile.STOCK_SUCCESS);
				responseDto.setData((Object) status);
			} else {
				responseDto.setResponseCode(HttpStatus.NO_CONTENT);
				responseDto.setResponseMessage(StockConstantFile.NO_CONTENT);
				responseDto.setData((Object) status);
			}
		} catch (Exception ex) {
			responseDto.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
			responseDto.setResponseMessage(StockConstantFile.INTERNAL_SERVER_ERROR);
			responseDto.setData((Object) ex);
		}
		return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
	}
	
	@PostMapping("/editStock")
	public ResponseEntity<ResponseDto> editStock(@RequestParam("id") Integer id, @RequestBody StockDto stockDto) throws Exception {
		Integer status = 0;
		try {
			status = fileService.editStock(id, stockDto);
			if (status > 0) {
				responseDto.setResponseCode(HttpStatus.ACCEPTED);
				responseDto.setResponseMessage(StockConstantFile.STOCK_SUCCESS);
				responseDto.setData((Object) status);
			} else {
				responseDto.setResponseCode(HttpStatus.NO_CONTENT);
				responseDto.setResponseMessage(StockConstantFile.NO_CONTENT);
				responseDto.setData((Object) status);
			}
		} catch (Exception ex) {
			responseDto.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
			responseDto.setResponseMessage(StockConstantFile.INTERNAL_SERVER_ERROR);
			responseDto.setData((Object) ex);
		}
		return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
	}
}
