package com.paolomanlunas.photoappdiscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer     // Categorise this as a Eureka Server
public class PhotoappDiscoveryServiceApplication {

   public static void main(String[] args) {
      SpringApplication.run(PhotoappDiscoveryServiceApplication.class, args);
   }

}
