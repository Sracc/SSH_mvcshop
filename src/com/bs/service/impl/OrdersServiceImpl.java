package com.bs.service.impl;

import java.util.List;

import javax.annotation.Resource
;

import org.springframework.stereotype.Service;

import com.bs.dao.OrdersDao;
import com.bs.entity.Orders;
import com.bs.entity.Search;
import com.bs.service.OrdersService;


@Service("ordersService")
public class OrdersServiceImpl extends BaseServiceImpl implements OrdersService {
	@Resource
	OrdersDao ordersDao ;
	public void add(Orders orders) {
		ordersDao.save(orders);
	}

	public void delete(Orders orders) {
		ordersDao.delete(orders);
	}

	public void update(Orders orders) {
		ordersDao.update(orders);
	}

	public Orders findById(int id) {
		return ordersDao.getById(id);
	}

	public Orders findByUserId(int id) {
		return ordersDao.getByUserId(id);
	}

	public List<Orders> search(Search search) {
		return ordersDao.query(search);
	}

}
