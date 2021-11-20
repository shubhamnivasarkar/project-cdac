package com.app.service;

import com.app.pojos.Address;

public interface IAddressService {

	Address getDeliveryAddress(Integer userId);

	Address updateAddress(Integer userId, Address adrr);

}
