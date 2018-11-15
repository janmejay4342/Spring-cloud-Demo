package com.example.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class ClientApplication {

    @Autowired
   // private DiscoveryClient client;
    
    private EurekaClient client;
    
    @Autowired
    private RestTemplateBuilder template;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
	
    @RequestMapping("/")
    public String getMessage(){
          RestTemplate build = template.build();
         // List<ServiceInstance> instances = client.getInstances("service");
          
          InstanceInfo instances = client.getNextServerFromEureka("service", false);
          
          String url = instances.getHomePageUrl();
          
          System.out.println(url);
          ResponseEntity<String> response = build.exchange(url, HttpMethod.GET, null, String.class);
          return response.getBody().toString();
    }
}
