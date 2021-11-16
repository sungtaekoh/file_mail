package com.care.root.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class MyScheduler {
	@Scheduled(cron="10 * * * * *")
	public void testSc() {
		System.out.println("10초에 한번씩 실행");
	}
}




