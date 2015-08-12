package demo;

import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("cloud")
public class UserServiceCloudConfig implements UserService {

	@Value("${vcap.services.user-service.credentials.url}")
	private URL url;
	
	@Override
	public URL getUrl() {
		return url;
	}

}
