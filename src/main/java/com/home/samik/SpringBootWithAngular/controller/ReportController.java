package com.home.samik.SpringBootWithAngular.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.home.samik.SpringBootWithAngular.dto.HighGraphDto;
import com.home.samik.SpringBootWithAngular.dto.LowGraphDto;
import com.home.samik.SpringBootWithAngular.dto.ResponseDto;
import com.home.samik.SpringBootWithAngular.dto.VolumeChartDto;
import com.home.samik.SpringBootWithAngular.service.ReportService;
import com.home.samik.SpringBootWithAngular.util.StockConstantFile;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ReportController {
	
	@Autowired
	private ResponseDto responseDto;
	
	@Autowired
	private ReportService reportService;
	
	@GetMapping("/getVolumeChart")
	public ResponseEntity<ResponseDto> getVolumeChart() throws Exception {
		try {
			List<VolumeChartDto> listVolumeChartDto = reportService.getVolumeChart();
			if (Objects.nonNull(listVolumeChartDto) && listVolumeChartDto.size() > 0) {
				responseDto.setResponseCode(HttpStatus.OK);
				responseDto.setResponseMessage(StockConstantFile.REPORT_SUCCESS);
				responseDto.setData((Object) listVolumeChartDto);
			} else {
				responseDto.setResponseCode(HttpStatus.NO_CONTENT);
				responseDto.setResponseMessage(StockConstantFile.NO_CONTENT);
				responseDto.setData((Object) listVolumeChartDto);
			}
		} catch (Exception ex) {
			responseDto.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
			responseDto.setResponseMessage(StockConstantFile.INTERNAL_SERVER_ERROR);
			responseDto.setData((Object) ex);
		}
		return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
	}
	
	@GetMapping("/getHighGraph")
	public ResponseEntity<ResponseDto> getHighGraph() throws Exception {
		try {
			List<HighGraphDto> listHighGraphDto = reportService.getHighGraph();
			if (Objects.nonNull(listHighGraphDto) && listHighGraphDto.size() > 0) {
				responseDto.setResponseCode(HttpStatus.OK);
				responseDto.setResponseMessage(StockConstantFile.REPORT_SUCCESS);
				responseDto.setData((Object) listHighGraphDto);
			} else {
				responseDto.setResponseCode(HttpStatus.NO_CONTENT);
				responseDto.setResponseMessage(StockConstantFile.NO_CONTENT);
				responseDto.setData((Object) listHighGraphDto);
			}
		} catch (Exception ex) {
			responseDto.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
			responseDto.setResponseMessage(StockConstantFile.INTERNAL_SERVER_ERROR);
			responseDto.setData((Object) ex);
		}
		return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
	}
	
	@GetMapping("/getLowGraph")
	public ResponseEntity<ResponseDto> getLowGraph() throws Exception {
		try {
			List<LowGraphDto> listLowGraphDto = reportService.getLowGraph();
			if (Objects.nonNull(listLowGraphDto) && listLowGraphDto.size() > 0) {
				responseDto.setResponseCode(HttpStatus.OK);
				responseDto.setResponseMessage(StockConstantFile.REPORT_SUCCESS);
				responseDto.setData((Object) listLowGraphDto);
			} else {
				responseDto.setResponseCode(HttpStatus.NO_CONTENT);
				responseDto.setResponseMessage(StockConstantFile.NO_CONTENT);
				responseDto.setData((Object) listLowGraphDto);
			}
		} catch (Exception ex) {
			responseDto.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR);
			responseDto.setResponseMessage(StockConstantFile.INTERNAL_SERVER_ERROR);
			responseDto.setData((Object) ex);
		}
		return new ResponseEntity<ResponseDto>(responseDto, responseDto.getResponseCode());
	}
}
