package com.WEATHER;

//REST client<->FrontController<->Web layer<->Service<->DAO<->DB

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookingAppApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(BookingAppApplication.class, args);
	}

}
