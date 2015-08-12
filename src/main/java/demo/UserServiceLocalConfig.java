package demo;

import java.net.URL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("default")
public class UserServiceLocalConfig implements UserService {

	@Value("${cloud-local.user-service.url}")
	private URL url;
	
	/* (non-Javadoc)
	 * @see demo.UserService#getUrl()
	 */
	@Override
	public URL getUrl()
	{
		return url;
	}
}