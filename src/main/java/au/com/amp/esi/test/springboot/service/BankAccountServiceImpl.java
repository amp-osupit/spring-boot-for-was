package au.com.amp.esi.test.springboot.service;

import au.com.amp.esi.spring.annotation.ProductionBean;
import au.com.amp.esi.test.springboot.model.BankAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@ProductionBean
public class BankAccountServiceImpl implements BankAccountService {

	private static final Logger log = LoggerFactory.getLogger(BankAccountServiceImpl.class);

	public BankAccountServiceImpl() {
		log.info("BankAccountServiceImpl starting up ");
	}

	@Override
	public BankAccount getAccount(String id) {
		BankAccount bankAccount = new BankAccount();
		bankAccount.setId(id);
		bankAccount.setBalance(BigDecimal.valueOf(200));
		return bankAccount;
	}
}
