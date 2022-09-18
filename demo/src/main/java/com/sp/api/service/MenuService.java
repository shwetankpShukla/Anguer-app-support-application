package com.sp.api.service;

import java.util.List;

import com.sp.api.domain.Menu;

public interface MenuService {
	
	List<Menu> getMenus();

    Menu getMenuById(String id);

    Menu insert(Menu menu);

    void updateMenu(String id, Menu menu);

    void deleteMenu(String menuId);

}
