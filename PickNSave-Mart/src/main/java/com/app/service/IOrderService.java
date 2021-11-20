package com.app.service;

import java.util.List;
import java.util.Optional;

import com.app.pojos.Order;
import com.app.pojos.ShopingCart;

public interface IOrderService {

	String placeOrder(List<ShopingCart> cartItems);//R

	String OrderCancelation(int O_id, int u_id);//R

	Optional<Order> getOrderDetailsById(int u_id);

	List<Order> getAllOrderDetails();

	List<Order> getAllOrderOfCustomer(int uId);//R

	String getDeliverInfoByOrder(Order o);

	String getShoperInfoByOrder(Order o);

//	int getCountOrders();
//
//	float grandTotal();

}
