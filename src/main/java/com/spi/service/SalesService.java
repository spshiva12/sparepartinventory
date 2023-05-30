package com.spi.service;

import java.util.List;

import com.spi.entity.Sales;

public interface SalesService {
	public boolean createSales(Sales sales);

	public boolean deleteSales(Integer sid);

	public List<Sales> getSales();

	public Sales getById(Integer sid);

	public List<Sales> getTop3();
}