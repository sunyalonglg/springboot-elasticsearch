package com.bootdo.model.system.service.impl;


import com.bootdo.model.system.dao.UserDao;
import com.bootdo.model.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public List findById(Map map) {
		return userDao.findById(map);
	}
}
