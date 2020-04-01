package com.zipcode.fullstackblog;

import com.zipcode.fullstackblog.controllers.*;
import com.zipcode.fullstackblog.models.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@SpringBootApplication
public class Application
{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}