package com.spi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spi.entity.Sales;
import com.spi.exception.SalesNotFoundException;
import com.spi.service.SalesServiceImpl;

@RestController
@RequestMapping("/sales")
@CrossOrigin(origins = "http://localhost:3000")
public class SalesController {

	@Autowired
	private SalesServiceImpl salesImpl;

	@PostMapping("/addSales")
	public ResponseEntity<String> addSales(@RequestBody Sales sales) {
		System.out.println(sales);
		boolean createSales = salesImpl.createSales(sales);
		String msg;
		if (createSales) {
			msg = "Added successfully";
		} else {
			msg = "Not added";
		}
		return ResponseEntity.ok(msg);
	}

	@GetMapping("/viewSales")
	public ResponseEntity<List<Sales>> getSales() throws SalesNotFoundException {
		List<Sales> sales = salesImpl.getSales();
		if (sales != null) {
			if (sales.isEmpty()) {
				throw new SalesNotFoundException("There is no Sales records in the database.");
			}
			return ResponseEntity.ok().body(sales);
		} else {
			throw new SalesNotFoundException("Sales Records are not found in database.");
		}
	}

	@GetMapping("/viewById/{sid}")
	public ResponseEntity<Sales> getSalesById(@PathVariable("sid") Integer sid) throws SalesNotFoundException {
		Sales byId = salesImpl.getById(sid);
		return ResponseEntity.ok().body(byId);
	}

	@PutMapping("/updateSales")
	public ResponseEntity<String> updateSales(@RequestBody Sales sales) throws SalesNotFoundException {
		Sales byId = salesImpl.getById(sales.getSid());
		if (byId == null) {
			throw new SalesNotFoundException("Sales record doesn't exist to update in the records");
		}
		boolean createSales = salesImpl.createSales(sales);
		String msg;
		if (createSales) {
			msg = "Updated successfully";
		} else {
			msg = "Not updated";
		}
		return ResponseEntity.ok(msg);
	}

	@DeleteMapping("/deleteSales/{sid}")
	public ResponseEntity<String> deleteSales(@PathVariable("sid") Integer sid) throws SalesNotFoundException {
		boolean deleteSales = salesImpl.deleteSales(sid);
		String msg;
		if (deleteSales)
			return ResponseEntity.ok().body("Deleted successfully");
		else
			throw new SalesNotFoundException("Sales not available in the records to perform delete");
	}

	@GetMapping("/viewTop3Sales")
	public ResponseEntity<List<Sales>> getTop3Sales() throws SalesNotFoundException {
		List<Sales> top3 = salesImpl.getTop3();
		if (top3 != null)
			return ResponseEntity.ok().body(top3);
		else
			throw new SalesNotFoundException("Sales Records are not found in database");
	}
}