package au.com.amp.esi.test.springboot.web.dispatchers.root;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController //root controller so no context/mapping specified
public class RootController {

	@RequestMapping(method= RequestMethod.GET)
	public @ResponseBody String getBalance() {
		return "listening";
	}
}
