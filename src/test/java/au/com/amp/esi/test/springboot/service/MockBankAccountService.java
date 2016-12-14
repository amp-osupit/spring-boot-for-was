package au.com.amp.esi.test.springboot.service;

import au.com.amp.esi.spring.annotation.IntegrationTestBean;
import au.com.amp.esi.test.springboot.model.BankAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@Service
@IntegrationTestBean
@Slf4j
public class MockBankAccountService  implements BankAccountService{

	public MockBankAccountService() {
		log.info("MockBankAccountService starting up ");
	}

	@Override
	public BankAccount getAccount(String id) {
		return createBankAccount(id, 100000l);
	}


	private BankAccount createBankAccount(String id, Long balance){
		BankAccount bankAccount = new BankAccount();
		bankAccount.setId(id);
		bankAccount.setBalance(BigDecimal.valueOf(balance));
		return bankAccount;
	}

}
