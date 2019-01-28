package com.home.samik.SpringBootWithAngular.dao;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManagerFactory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.home.samik.SpringBootWithAngular.entity.StockDetails;

@Repository
public class FileDaoImpl implements FileDao {

	@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Override
	public void uploadFileDataToDB(List<StockDetails> listOfStocks) throws Exception {
		saveStockDetails(listOfStocks);
	}

	private void saveStockDetails(List<StockDetails> listOfStocks) {
		listOfStocks.forEach(i -> {
			StockDetails stockDetails = i;
			Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
			if (Objects.nonNull(stockDetails)) {
				session.beginTransaction();
				session.save(stockDetails);
				session.getTransaction().commit();
				session.close();
			}
		});
	}

	@Override
	public List<StockDetails> getAllStockData(Integer pageIndex, Integer changeNoOfRecords, String orderByCol)
			throws Exception {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		List<StockDetails> list = null;
		try {
			Query<StockDetails> query = session.createQuery("from StockDetails ORDER BY " + orderByCol.trim(),
					StockDetails.class);
			query.setFirstResult(((pageIndex - 1) * 100) + 1);
			query.setMaxResults(changeNoOfRecords);
			list = query.getResultList();
		} finally {
			session.clear();
			session.close();
		}
		return list;
	}

	@Override
	public List<StockDetails> getDetailsByName(String stockName) throws Exception {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		Query<StockDetails> query = session.createQuery("from StockDetails where stock_company_symbol = :stockName",
				StockDetails.class);
		query.setParameter("stockName", stockName);
		return query.getResultList();
	}

	@Override
	public List<StockDetails> getDetailsByPerformance() {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		Query<StockDetails> query = session.createNativeQuery(
				"select * from stock_details where stock_company_symbol IN\r\n"
						+ "(select stock_company_symbol from stock_details group by stock_company_symbol having sum(stock_volume) > 850000000)",
				StockDetails.class);
		return query.getResultList();
	}

	@Override
	public Integer getTotalNoOfStock() {
		Session session = entityManagerFactory.unwrap(SessionFactory.class).openSession();
		Integer count = 0;
		try {
			Query<?> query = session.createNativeQuery("select count(*) from stock_details");
			List<?> list = query.getResultList();
			if (Objects.nonNull(list) && list.size() > 0) {
				count = (Integer) list.get(0);
			}
		} finally {
			session.clear();
			session.close();
		}
		return count;
	}

}
