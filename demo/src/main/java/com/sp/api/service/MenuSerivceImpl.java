package com.sp.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.api.domain.Menu;
import com.sp.api.repository.MenuRepository;

@Service
public class MenuSerivceImpl implements MenuService {
	
	@Autowired
	private MenuRepository repository;

	@Override
	public List<Menu> getMenus() {		
		return repository.findAll();
	}

	@Override
	public Menu getMenuById(String id) {
		return repository.findById(id).get();
	}

	@Override
	public Menu insert(Menu menu) {		
		return repository.save(menu);
	}

	@Override
	public void updateMenu(String id, Menu menu) {
		Menu menu2 =getMenuById(id);
		BeanUtils.copyProperties(menu, menu2);
		repository.save(menu2);
	}

	@Override
	public void deleteMenu(String menuId) {
		// TODO Auto-generated method stub

	}

}
