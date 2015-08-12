/**
 * 
 */
package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author grog
 */
@RestController
public class HelloController {

	@Autowired
	private UserService userServiceConfig;
	
	@RequestMapping("/")
	public String hello() {
		StringBuilder strBuilder = new StringBuilder("Hello!\nUser service is:\n");
		strBuilder.append(userServiceConfig.getUrl().toString());
		return strBuilder.toString();
	}
}
