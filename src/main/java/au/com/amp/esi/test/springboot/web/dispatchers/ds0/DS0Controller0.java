package au.com.amp.esi.test.springboot.web.dispatchers.ds0;

import au.com.amp.esi.test.springboot.model.BalanceMessage;
import au.com.amp.esi.test.springboot.model.BankAccount;
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
@RequestMapping("/balance")
public class DS0Controller0 {

    private static Logger log = LoggerFactory.getLogger(DS0Controller0.class);

    @Autowired
    private BankAccountService bankAccountService;

    public DS0Controller0() {
        log.info("DS0Controller0 starting up");
    }

    private static final String template = "(Original) Hello, %s! - your account balance is: $%s.00";
    private final        AtomicLong counter  = new AtomicLong();

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody BalanceMessage getBalance(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        BankAccount bankAccount = bankAccountService.getAccount("A1");
        return new BalanceMessage(String.format(template, name, bankAccount.getBalance()));
    }

}
