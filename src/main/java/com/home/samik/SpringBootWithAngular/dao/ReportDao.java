package com.home.samik.SpringBootWithAngular.dao;

import java.util.List;

public interface ReportDao {
	public List<?> getVolumeChart() throws Exception;
	public List<?> getHighGraph() throws Exception;
	public List<?> getLowGraph() throws Exception;
}
