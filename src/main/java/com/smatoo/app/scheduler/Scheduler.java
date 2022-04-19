package com.smatoo.app.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.smatoo.app.tracker.ITracker;

@Configuration
@EnableScheduling
public class Scheduler {
	@Autowired
	ITracker autoService;
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Scheduled(cron = "0 */1 * * * *")
	public void logingCountClearingData() {
		logger.info(String.valueOf(autoService.currentCountUniqueRequest()));
		autoService.clear();
	    long now = System.currentTimeMillis() / 1000;
	    logger.info("schedule tasks using cron jobs - " + now);
	}
}
