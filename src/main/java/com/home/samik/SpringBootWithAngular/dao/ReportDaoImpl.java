package com.home.samik.SpringBootWithAngular.dao;

import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public class ReportDaoImpl implements ReportDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public List<?> getVolumeChart() throws Exception {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		List<?> list = null;
		try {
			Query<?> query = session.createNativeQuery(
					"select stock_company_symbol, sum(CAST(stock_volume AS BIGINT)) from stock_details group by stock_company_symbol");
			list = query.getResultList();
		} finally {
			session.clear();
			session.close();
		}
		return list;
	}

	@Override
	public List<?> getHighGraph() throws Exception {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		List<?> list = null;
		try {
			Query<?> query = session.createNativeQuery(
					"select stock_company_symbol, sum(CAST(stock_high AS BIGINT)) from stock_details group by stock_company_symbol");
			list = query.getResultList();
		} finally {
			session.clear();
			session.close();
		}
		return list;
	}

	@Override
	public List<?> getLowGraph() throws Exception {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		List<?> list = null;
		try {
			Query<?> query = session.createNativeQuery(
					"select stock_company_symbol, sum(CAST(stock_low AS BIGINT)) from stock_details group by stock_company_symbol");
			list = query.getResultList();
		} finally {
			session.clear();
			session.close();
		}
		return list;
	}
}
