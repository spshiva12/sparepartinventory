package com.spi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spi.entity.Sales;
import com.spi.exception.SalesNotFoundException;
import com.spi.repo.SalesRepository;

@Service
public class SalesServiceImpl implements SalesService {

	@Autowired
	private SalesRepository repo;

	@Override
	public boolean createSales(Sales sales) {
		Sales isSaved = repo.save(sales);
		if (isSaved != null)
			return true;
		else
			return false;
	}

	@Override
	public boolean deleteSales(Integer sid) {
		Optional<Sales> findById = repo.findById(sid);
		if (findById.get() != null) {
			repo.deleteById(sid);
			return true;
		} else
			return false;
	}

	@Override
	public List<Sales> getSales() {
		try {
			List<Sales> findAll = repo.findAll();
			return findAll;
		} catch (Exception e) {
			throw new SalesNotFoundException("Sales Record table not available in the database");
		}
	}

	@Override
	public Sales getById(Integer sid) {
		Optional<Sales> findById = repo.findById(sid);
		return repo.findById(sid).orElseThrow(() -> new SalesNotFoundException("Sales Not Found With This Id" + sid));
	}

	@Override
	public List<Sales> getTop3() {
		List<Sales> topThreeSales = repo.getTopThreeSales();

		return topThreeSales;
	}
}