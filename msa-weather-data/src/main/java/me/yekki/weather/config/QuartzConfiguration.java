package me.yekki.weather.config;

import me.yekki.weather.common.Constants;
import me.yekki.weather.job.WeatherDataSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfiguration {


    @Bean
    public JobDetail syncDataJobDetail() {

        return JobBuilder.newJob(WeatherDataSyncJob.class).withIdentity("WeatherDataSyncJob").storeDurably().build();
    }

    @Bean
    public Trigger dataSyncTrigger() {

        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(Constants.UPDATE_TIME_INTERVAL).repeatForever();
        return TriggerBuilder.newTrigger().forJob(syncDataJobDetail()).withIdentity("WeatherDataSyncTrigger").withSchedule(scheduleBuilder).build();
    }
}
