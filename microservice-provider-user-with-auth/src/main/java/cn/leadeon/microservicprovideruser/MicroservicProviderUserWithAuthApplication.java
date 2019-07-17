package cn.leadeon.microservicprovideruser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicProviderUserWithAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicProviderUserWithAuthApplication.class, args);
	}

}
