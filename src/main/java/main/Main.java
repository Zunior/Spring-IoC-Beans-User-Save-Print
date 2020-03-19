package main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.MyConfig;
import domain.User;
import service.UserService;

public class Main {
	
	public static void main(String[] args) {
//		Main main = new Main();
		
		System.out.println("Rad sa jednim kontejnerom");
		
		//kreirati kontejner
		BeanFactory container = new AnnotationConfigApplicationContext(MyConfig.class);
		
//		//dohvati usera i postavi vrednosti.....
		User user1 = (User) container.getBean("user");
		User user2 = (User) container.getBean("user");
		user1.setFirstname("Pera");user1.setLastname("Peric");user1.setUsername("pera");user1.setPassword("123");
		user2.setFirstname("Zika");user2.setLastname("Zikic");user2.setUsername("zika");user2.setPassword("123");
//		
		
		UserService userService = (UserService) container.getBean("userService");
		userService.save(user1);
		userService.save(user2);
		//pozvati service metodu za prikaz
		userService.printAll();
		
		//=================================================================================
		System.out.println("Rad iz main-a ---  vishe kontejnera");
		//iz kontejnera uzeti main objekat
		Main main = (Main) container.getBean("main");
		
		//pozvati metodu adduser iz maina
		main.addUser(user1);
		main.addUser(user2);
		//pozvati metodu print user
		main.printUsers();
		
	}
	
	void addUser(User user) {
		//poziv servisa
		BeanFactory container = new AnnotationConfigApplicationContext(MyConfig.class);
		UserService userService = (UserService) container.getBean("userService");
		userService.save(user);
	}
	
	void printUsers() {
		BeanFactory container = new AnnotationConfigApplicationContext(MyConfig.class);
		UserService userService = (UserService) container.getBean("userService");
		userService.printAll();
	}
}
