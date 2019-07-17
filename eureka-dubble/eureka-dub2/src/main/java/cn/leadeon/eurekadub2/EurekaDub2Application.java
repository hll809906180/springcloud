package cn.leadeon.eurekadub2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaDub2Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDub2Application.class, args);
	}

}
