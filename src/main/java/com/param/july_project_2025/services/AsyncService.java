package com.param.july_project_2025.services;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AsyncService {

	@Async("async1")
	public void asyncMethod1() throws InterruptedException {
		log.info("Thread Name in AsyncService: {}", Thread.currentThread().getName());
		for (int i = 1; i <= 10; i++) {
			Thread.sleep(2000);
			log.info("Current Time: {}", i);
		}
	}

	public void asyncMethod2() {
		Runnable r = () -> {
			log.info("Thread Name in AsyncService: {}", Thread.currentThread().getName());
			for (int i = 1; i <= 10; i++) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				log.info("Current Time: {}", i);
			}
		};

		log.info("Thread Name in AsyncService: {}", Thread.currentThread().getName());
		CompletableFuture.runAsync(new Thread(r, "My Thread"));
	}
}