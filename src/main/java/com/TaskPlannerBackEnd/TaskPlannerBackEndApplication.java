package com.TaskPlannerBackEnd;

import com.TaskPlannerBackEnd.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TaskPlannerBackEndApplication {

	@Bean
	public FilterRegistrationBean jwtFilter()
	{
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter( new JwtFilter() );
		registrationBean.addUrlPatterns( "/taskplanner/*" );

		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(TaskPlannerBackEndApplication.class, args);
	}

}
