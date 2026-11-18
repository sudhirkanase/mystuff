package com.tmt.doc.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
//@EnableDiscoveryClient
@PropertySources({
		// @PropertySource(value =
		// "file:${ENV_HOME}/config/services/taskmanagement.properties")
		@PropertySource(value = "classpath:doc-management.properties") })
public class DocManagementWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocManagementWebApplication.class, args);
	}

}
