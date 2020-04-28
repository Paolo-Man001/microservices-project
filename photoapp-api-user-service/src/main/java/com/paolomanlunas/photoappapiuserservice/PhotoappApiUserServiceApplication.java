package com.paolomanlunas.photoappapiuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoappApiUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoappApiUserServiceApplication.class, args);
	}

}
