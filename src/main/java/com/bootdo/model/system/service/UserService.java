package com.bootdo.model.system.service;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UserService {

	public List findById(Map map);
}
