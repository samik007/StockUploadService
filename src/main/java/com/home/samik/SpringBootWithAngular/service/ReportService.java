package com.home.samik.SpringBootWithAngular.service;

import java.util.List;

import com.home.samik.SpringBootWithAngular.dto.HighGraphDto;
import com.home.samik.SpringBootWithAngular.dto.LowGraphDto;
import com.home.samik.SpringBootWithAngular.dto.VolumeChartDto;

public interface ReportService {
	public List<VolumeChartDto> getVolumeChart() throws Exception;
	public List<HighGraphDto> getHighGraph() throws Exception;
	public List<LowGraphDto> getLowGraph() throws Exception;
}
