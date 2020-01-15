package com.zensar.example.freemarker;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.example.freemarker.dto.MailRequest;
import com.zensar.example.freemarker.dto.MailResponse;
import com.zensar.example.freemarker.service.EmailService;

@SpringBootApplication
@RestController
public class FreemarkerApplication {

	@Autowired
	private EmailService service;
	
	@PostMapping("/send")
	public MailResponse sendEmail(@RequestBody MailRequest request) {
		
		Map<String,Object> model = new HashMap();
		model.put("Name", request.getUsername());
		model.put("Location", "Banglore, India");
		String template="email-template.ftl";
		return service.sendEmail(request, model,template);
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(FreemarkerApplication.class, args);
	}

}
