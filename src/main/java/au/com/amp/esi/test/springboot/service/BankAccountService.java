package au.com.amp.esi.test.springboot.service;

import au.com.amp.esi.test.springboot.model.BankAccount;

public interface BankAccountService {

	BankAccount getAccount(String id);
}
