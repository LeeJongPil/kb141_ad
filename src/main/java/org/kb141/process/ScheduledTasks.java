package org.kb141.process;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(cron = "*/5 * * * * *")
	public void reportCurrentTime() {

		System.out.println("The time is now " + dateFormat.format(new Date()));

	}

}
