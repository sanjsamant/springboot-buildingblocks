package com.stacksimplify.restservices.config;

import org.springframework.context.annotation.Configuration;

import io.micrometer.appoptics.AppOpticsConfig;
import io.micrometer.appoptics.AppOpticsMeterRegistry;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.lang.Nullable;

@Configuration
public class MonitoringConfig {
	
	AppOpticsConfig appopticsConfig = new AppOpticsConfig() {
	    @Override
	    public String apiToken() {
	        return "JFruIIlOgvJsto5tDZv8a1YPozXMyHllp2jAJunaCHcodevuy9cjR-qqraQlD6769L_s3lk";
	    }

	    @Override
	    @Nullable
	    public String get(String k) {
	        return null;
	    }
	};
	MeterRegistry registry = new AppOpticsMeterRegistry(appopticsConfig, Clock.SYSTEM);

}
