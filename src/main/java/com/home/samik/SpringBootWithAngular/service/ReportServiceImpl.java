package com.home.samik.SpringBootWithAngular.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.home.samik.SpringBootWithAngular.dao.ReportDao;
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
	
}
