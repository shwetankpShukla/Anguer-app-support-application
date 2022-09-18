package com.sp.api.laoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.sp.api.domain.Menu;
import com.sp.api.repository.MenuRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MenuLoader implements CommandLineRunner {
	
	@Autowired
	private MenuRepository repository;

	@Override
	public void run(String... args) throws Exception {
		loadinitialMenu();
		
	}

	private void loadinitialMenu() {
		if(repository.count()==0) {
			repository.save(Menu.builder()
					.menuId("home").menuName("Home").menuImg("home").menuUrl("/dashboard/welcome").build());
			repository.save(Menu.builder()
					.menuId("student").menuName("Student").menuImg("person_pin").menuUrl("/dashboard/student").build());
			repository.save(Menu.builder()
					.menuId("profile").menuName("Profile").menuImg("person").menuUrl("/dashboard/profile").build());
			repository.save(Menu.builder()
					.menuId("about").menuName("About").menuImg("info").menuUrl("/dashboard/about").build());
			repository.save(Menu.builder()
					.menuId("help").menuName("Help").menuImg("help_outline").menuUrl("/dashboard/help").build());
			repository.save(Menu.builder()
					.menuId("setting").menuName("Setting").menuImg("settings").menuUrl("/dashboard/setting").build());
			repository.save(Menu.builder()
					.menuId("inbox").menuName("Inbox").menuImg("inbox").menuUrl("/dashboard/inbox").build());
	
		}
		log.info("Intial Menu Loaded..");
		
	}

}
