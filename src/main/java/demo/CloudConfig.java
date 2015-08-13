package demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
@EnableConfigurationProperties
public class CloudConfig {

	@ConfigurationProperties(prefix = "vcap.services.user-service.credentials")
	@Bean
	public UserService userService() {
		return new UserService();
	}

}
