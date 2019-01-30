package com.home.samik.SpringBootWithAngular.service;

import java.util.List;

import com.home.samik.SpringBootWithAngular.dto.VolumeChartDto;

public interface ReportService {
	public List<VolumeChartDto> getVolumeChart() throws Exception;
}
