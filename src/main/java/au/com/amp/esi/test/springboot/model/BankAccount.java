package au.com.amp.esi.test.springboot.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class BankAccount {

	private String id;
	private BigDecimal balance;
}
