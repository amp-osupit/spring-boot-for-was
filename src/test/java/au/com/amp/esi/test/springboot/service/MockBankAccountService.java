package au.com.amp.esi.test.springboot.service;

import au.com.amp.esi.spring.annotation.IntegrationTestBean;
import au.com.amp.esi.test.springboot.model.BankAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@Service
@IntegrationTestBean
public class MockBankAccountService  implements BankAccountService{

	private static final Logger log = LoggerFactory.getLogger(MockBankAccountService.class);

	private BankAccountService bankAccountService = mock(BankAccountService.class);

	public MockBankAccountService() {
		log.info("MockBankAccountService starting up ");
		when(bankAccountService.getAccount(anyString())).thenReturn(createBankAccount("A1", 100000l));
	}

	@Override
	public BankAccount getAccount(String id) {
		return bankAccountService.getAccount(id);
	}


	private BankAccount createBankAccount(String id, Long balance){
		BankAccount bankAccount = new BankAccount();
		bankAccount.setId(id);
		bankAccount.setBalance(BigDecimal.valueOf(balance));
		return bankAccount;
	}

}
