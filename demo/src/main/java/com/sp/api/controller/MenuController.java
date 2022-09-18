package com.sp.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.api.domain.Menu;
import com.sp.api.service.MenuService;

@RestController
@RequestMapping("/api/v1/menu")
@CrossOrigin
public class MenuController {

	@Autowired
	private MenuService service;

	@GetMapping
	public ResponseEntity<List<Menu>> getAllMenu() {
		List<Menu> menu = service.getMenus();
		return new ResponseEntity<>(menu, HttpStatus.OK);
	}

	@GetMapping({ "/{MenuId}", })
	public ResponseEntity<Menu> getMenu(@PathVariable String MenuId) {
		return new ResponseEntity<>(service.getMenuById(MenuId), HttpStatus.OK);
	}

	@PostMapping(value = "/", produces = "application/json")
	public ResponseEntity<Menu> saveMenu(@RequestBody Menu Menu) {
		Menu Menu1 = service.insert(Menu);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("Menu", "/api/v1/Menu/" + Menu1.getMenuId().toString());
		return new ResponseEntity<>(Menu1, httpHeaders, HttpStatus.CREATED);
	}

	@PutMapping({ "/{MenuId}" })
	public ResponseEntity<Menu> updateMenu(@PathVariable("MenuId") String MenuId, @RequestBody Menu Menu) {
		service.updateMenu(MenuId, Menu);
		return new ResponseEntity<>(service.getMenuById(MenuId), HttpStatus.OK);
	}

	@DeleteMapping({ "/{MenuId}" })
	public ResponseEntity<Menu> deleteMenu(@PathVariable("MenuId") String MenuId) {
		service.deleteMenu(MenuId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
