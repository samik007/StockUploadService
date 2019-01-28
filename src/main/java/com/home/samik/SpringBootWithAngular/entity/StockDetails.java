package com.home.samik.SpringBootWithAngular.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
public class StockDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="stock_id")
	private Integer id;
	
	@Column(name="stock_date")
	private String date;
	
	@Column(name="stock_company_symbol")
	private String companySymbol;
	
	@Column(name="stock_open")
	private float open;
	
	@Column(name="stock_close")
	private float close;
	
	@Column(name="stock_low")
	private float low;
	
	@Column(name="stock_high")
	private float high;
	
	@Column(name="stock_volume")
	private long volume;
	
	public StockDetails() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCompanySymbol() {
		return companySymbol;
	}
	public void setCompanySymbol(String companySymbol) {
		this.companySymbol = companySymbol;
	}
	public float getOpen() {
		return open;
	}
	public void setOpen(float open) {
		this.open = open;
	}
	public float getClose() {
		return close;
	}
	public void setClose(float close) {
		this.close = close;
	}
	public float getLow() {
		return low;
	}
	public void setLow(float low) {
		this.low = low;
	}
	public float getHigh() {
		return high;
	}
	public void setHigh(float high) {
		this.high = high;
	}
	public long getVolume() {
		return volume;
	}
	public void setVolume(long volume) {
		this.volume = volume;
	}
	
}
