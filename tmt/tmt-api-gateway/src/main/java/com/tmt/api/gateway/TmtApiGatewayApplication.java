package com.tmt.api.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.tmt.api.gateway.filter.PreFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class TmtApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmtApiGatewayApplication.class, args);
	}
	
	@Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }

}
