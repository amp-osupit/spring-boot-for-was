package au.com.amp.esi.test.springboot.dispatcher.hello;

import au.com.amp.esi.test.springboot.model.BankAccount;
import au.com.amp.esi.test.springboot.model.Greeting;
import au.com.amp.esi.test.springboot.service.BankAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicLong;

@Controller
@RequestMapping("/hello-world")
public class HelloWorldController {

    private static Logger log = LoggerFactory.getLogger(HelloWorldController.class);

    @Autowired
    private BankAccountService bankAccountService;

    public HelloWorldController() {
        log.info("HelloWorldController starting up");
    }

    private static final String template = "Original Hello, %s! - your account balance is: $%s.00";
    private final        AtomicLong counter  = new AtomicLong();

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody Greeting sayHello(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        BankAccount bankAccount = bankAccountService.getAccount("A1");
        return new Greeting(counter.incrementAndGet(), String.format(template, name, bankAccount.getBalance()));
    }

}
