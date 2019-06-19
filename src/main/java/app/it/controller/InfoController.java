package app.it.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

	@Autowired
	DiscoveryClient discoveryClient;

	@RequestMapping("/dc")
	public String dc() {
		String services = "服务: " + discoveryClient.getServices();
		LoggerFactory.getLogger(this.getClass()).info(String.format("services:", services));
		return services;
	}

}