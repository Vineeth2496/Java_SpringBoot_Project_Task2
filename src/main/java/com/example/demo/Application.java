package com.example.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctxt=	SpringApplication.run(Application.class, args);
	Dao_logics d=(Dao_logics)ctxt.getBean("dao_logics");
//	int r=d.insert();
//	System.out.println("Record Updated: "+r);
	
//	int r=d.update();
//	System.out.println("Name Updated Sucessfully:"+r);
	
//	int dd=d.delete();
//	System.out.println("Profile Deleted Sucessfully:"+dd);
	
	List<Data> t=d.fetch();
	for(Data dd: t)
	{
		System.out.println(dd.getId());
		System.out.println(dd.getName());
		System.out.println(dd.getSal());
	}
	
	}

}