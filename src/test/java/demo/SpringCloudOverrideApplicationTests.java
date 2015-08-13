package demo;

import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringCloudOverrideApplication.class)
@WebAppConfiguration
public class SpringCloudOverrideApplicationTests {

	@Autowired
	private UserService userService;
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void userServiceContainsUrl()
	{
		assertThat(userService.getUrl(), notNullValue());
	}
}
