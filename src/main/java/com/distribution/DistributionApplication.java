package com.distribution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/*@SpringBootApplication
@Configuration
@EnableScheduling*/
@ServletComponentScan //通过 @WebServlet、@WebFilter、@WebListener 注解自动注册
@SpringBootApplication
//@Import({DataSourceConfig.class,InterceptorConfig.class})
public class DistributionApplication {
	public static void main(String[] args) {
		SpringApplication.run(DistributionApplication.class, args);
	/*	new SpringApplicationBuilder()
				.sources(AppConfig.class)
				.bannerMode(Banner.Mode.OFF)
				.build()
				.run(args);*/
	}
}
