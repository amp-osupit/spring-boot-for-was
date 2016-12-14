package au.com.amp.esi.test.springboot.web.dispatchers.ds1;

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

@Controller
@RequestMapping("/balance")
public class DS1Controller0 {

    private static final Logger log = LoggerFactory.getLogger(DS1Controller0.class);
    private static final String template = "Alt Hello, %s! - your account balance is: $%s.00";

    @Autowired
    private BankAccountService bankAccountService;

    public DS1Controller0() {
        log.info("DS1Controller0 starting up");
    }

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody BalanceMessage getBalance(@RequestParam(value="name", required=false, defaultValue="Stranger") String name) {
        BankAccount bankAccount = bankAccountService.getAccount("A1");
        return new BalanceMessage(String.format(template, name, bankAccount.getBalance()));
    }

}
