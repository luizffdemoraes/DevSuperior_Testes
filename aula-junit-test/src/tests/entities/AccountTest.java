package tests.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

class AccountTest {

	@Test
	public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
		//Arrange cenario
		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = new Account(1L, 0.0);
		
		//Act acao
		acc.deposit(amount);
		
		//Assert verificacao se os valores são iguais
		Assertions.assertEquals(expectedValue, acc.getBalance());
		
		
	}

}
