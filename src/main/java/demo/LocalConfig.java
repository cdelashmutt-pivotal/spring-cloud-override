package demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("default")
@EnableConfigurationProperties
public class LocalConfig {

	@ConfigurationProperties(prefix = "user-service")
	@Bean
	public UserService userService() {
		return new UserService();
	}

}