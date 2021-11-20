package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CartDao;
import com.app.dao.OrderDao;
import com.app.dao.ProductDao;
import com.app.dao.ShoperInfoDao;
import com.app.pojos.Address;
import com.app.pojos.Order;
import com.app.pojos.Product;
import com.app.pojos.ShoperInfo;
import com.app.pojos.ShopingCart;
import com.app.pojos.Status;

@Service
@Transactional
public class OrderServiceImpl implements IOrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private CartDao cartDao;



	@Autowired
	private IAddressService addressService;

	@Autowired
	private ShoperInfoDao shoperInfoDao;

	@Autowired
	private ProductDao productDao;

	
	  @Override public List<Order> getAllOrderDetails() { // TODO Auto-generated
	 // method stub 
	  return orderDao.findAll(); }
	  
	  
	  @Override public Optional<Order> getOrderDetailsById(int u_id) { // TODO
	 // Auto-generated method stub
	  return orderDao.findById(u_id); }
	 
	@Override
	public List<Order> getAllOrderOfCustomer(int uId) {
		// TODO Auto-generated method stub
		return orderDao.getallOrdersOfCustomer(uId);
	}

	@Override
	public String OrderCancelation(int O_id, int u_id) {
		Order order = orderDao.findById(O_id).get();
		orderDao.delete(order);

		shoperInfoDao.deleteAll(shoperInfoDao.getShInfos(order.getOrderId()));
		Product p = productDao.findById(order.getProduct().getP_Id()).get();
		p.setStocks(p.getStocks() + order.getQuntity());
		return "order cancelled successfully!";
	}

	@Override
	public String placeOrder(List<ShopingCart> cartItems) {
		cartItems.forEach(i -> {
			Order order = new Order();
			order.setCustomer(i.getCustomer());
			order.setProduct(i.getProduct());
			order.setQuntity(i.getQuantity());
			order.setUnitPrice(i.getProduct().getPrice());
			order.setSubtotal(i.getQuantity() * i.getProduct().getPrice());
			order.setStatus(Status.PACK);
			Order o = orderDao.save(order);
			getDeliverInfoByOrder(o);
			getShoperInfoByOrder(o);
		});

		cartDao.deleteAll(cartItems);

		return "order placed successfully";
	}

	public String getDeliverInfoByOrder(Order o) {
		Address a = addressService.getDeliveryAddress(o.getCustomer().getId());
		if (a == null) {
			// throw erorr for not transection rollback
			return "you need to first put deliverAddress please !!!! ";
		}
		Product p = o.getProduct();
		// DeliveryInfo d= new DeliveryInfo(o.getOrderId(), p.getProductName(),
		// o.getCustomer().getFirstName()+" "+o.getCustomer().getLastName(),
		// o.getOdate().plusDays(7), o.getStatus(), a);
		// deliveryDao.save(d);
		return "added in deliveryListTable";
	}

	@Override
	public String getShoperInfoByOrder(Order o) {
		ShoperInfo s=new ShoperInfo(o.getProduct().getShop().getS_Id(), o.getOrderId(), o.getOdate(), o.getProduct().getP_Id(), o.getProduct().getProductName(), o.getQuntity(), o.getUnitPrice(), o.getSubtotal());
		shoperInfoDao.save(s);
		return "added in shoperInfoTable";
	}
	
	
	

}
