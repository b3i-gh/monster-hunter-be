package com.b3i.monsterhunter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import lombok.extern.slf4j.Slf4j;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MonsterhunterApplication {


	@Value("${spring.servlet.multipart.max-file-size}")
	private String maxFileSize;

	@Value("${spring.servlet.multipart.max-request-size}")
	private String maxRequestSize;

	@PostConstruct
	public void logConfig() {
		log.info("Max file size configured: {}", maxFileSize);
		log.info("Max request size configured: {}", maxRequestSize);
	}

	public static void main(String[] args) {
		SpringApplication.run(MonsterhunterApplication.class, args);
	}

}
