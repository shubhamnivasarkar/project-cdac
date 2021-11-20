package com.app.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.AddressRepository;
import com.app.pojos.Address;

@Service// It is used at class level. It tells spring that class contain business level logic.
@Transactional/*- When we add this annotation on a class, SC knows that this is the Transactional bean, 
means this is going to interact with the Database, so there you do not have to write those boilerplate code. 
All the transaction management task such as getting session, begin transaction, commit/rollback 
and returning collection to pool is done by Spring supplied Transaction Manger Bean.
*/
public class AddressServiceImpl implements IAddressService {
	
	@Autowired
	private AddressRepository addrRepo;
	@Autowired
	private UserServiceImpl user;

	/*
	 * @Override public Address getAddressesByUserId(Integer userId) {
	 * 
	 * return addrRepo.getAddressesByUserId(userId); }
	 */

	/*
	 * @Override public Address addOrEditAddress(Address addr) {
	 * 
	 * return addrRepo.save(addr); }
	 * 
	 * @Override public String deleteAddressById(Integer id) {
	 * addrRepo.deleteById(id); return "Address with id: " + id + " was deleted"; }
	 */
	
	@Override
	public Address getDeliveryAddress(Integer userId) {
		// TODO Auto-generated method stub
		return addrRepo.getDelivryAddress(userId);
	}
	
	@Override
	public Address updateAddress(Integer userId, Address adrr) {
	
		Address a=addrRepo.getDelivryAddress(userId);
		if(a !=null) {
		a.setAddressLine1(adrr.getAddressLine1());
		a.setAddressLine2(adrr.getAddressLine2());
		a.setCity(adrr.getCity());
		a.setPinCode(adrr.getPinCode());
		System.out.println(a);
		return addrRepo.save(a);
		}else {
			adrr.setSelectedUser(user.findById(userId));
			System.out.println(a);
			return addrRepo.save(adrr);
		}
		
		
	}
}
