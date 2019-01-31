package com.home.samik.SpringBootWithAngular.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.samik.SpringBootWithAngular.dao.ReportDao;
import com.home.samik.SpringBootWithAngular.dto.HighGraphDto;
import com.home.samik.SpringBootWithAngular.dto.LowGraphDto;
import com.home.samik.SpringBootWithAngular.dto.VolumeChartDto;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private ReportDao reportDao;
	
	@Override
	public List<VolumeChartDto> getVolumeChart() throws Exception {
		List<?> rawListVolumeChartDto = reportDao.getVolumeChart();
		final List<VolumeChartDto> listVolumeChartDto = new ArrayList<>();
		if (Objects.nonNull(rawListVolumeChartDto) && rawListVolumeChartDto.size() > 0) {
			rawListVolumeChartDto.forEach(i -> {
				VolumeChartDto volumeChartDto = (VolumeChartDto) i;
				listVolumeChartDto.add(volumeChartDto);
			});
		}
		return listVolumeChartDto;
	}

	@Override
	public List<HighGraphDto> getHighGraph() throws Exception {
		List<?> rawListHighGraphDto = reportDao.getHighGraph();
		final List<HighGraphDto> listHighGraphDto = new ArrayList<>();
		if (Objects.nonNull(rawListHighGraphDto) && rawListHighGraphDto.size() > 0) {
			rawListHighGraphDto.forEach(i -> {
				HighGraphDto highGraphDto = (HighGraphDto) i;
				listHighGraphDto.add(highGraphDto);
			});
		}
		return listHighGraphDto;
	}

	@Override
	public List<LowGraphDto> getLowGraph() throws Exception {
		List<?> rawListLowGraphDto = reportDao.getLowGraph();
		final List<LowGraphDto> listLowGraphDto = new ArrayList<>();
		if (Objects.nonNull(rawListLowGraphDto) && rawListLowGraphDto.size() > 0) {
			rawListLowGraphDto.forEach(i -> {
				LowGraphDto lowGraphDto = (LowGraphDto) i;
				listLowGraphDto.add(lowGraphDto);
			});
		}
		return listLowGraphDto;
	}
	
}
