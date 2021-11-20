package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ShopDao;
import com.app.dao.ShoperInfoDao;
import com.app.pojos.Shop;
import com.app.pojos.ShoperInfo;


@Service
@Transactional
public class ShoperInfoImpl implements IShoperInfoService {
	
	@Autowired
	private ShoperInfoDao shopDao;
	@Autowired
	private ShopDao shop;


	@Override
		public List<ShoperInfo> getShoperInfoUId(int sid) {
		System.out.println(sid);
			return shopDao.getShoperInfo(sid);
		}	
	

}
