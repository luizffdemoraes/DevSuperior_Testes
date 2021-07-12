package tests.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

class AccountTest {
	
	/*
	 * Função Deposito deve incrementar e descontar a taxa quando a quantia for positiva
	 */

	@Test
	public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
		// Arrange cenario
		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();

		// Act acao
		acc.deposit(amount);

		// Assert verificacao se os valores são iguais
		Assertions.assertEquals(expectedValue, acc.getBalance());

	}
	/*
	 * Função deposito não faz nada quando informar uma quantia negatia
	 */
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		// Arrange cenário
		double expectedValue = 100.0;
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200;
		
		// Act ação
		acc.deposit(amount);
		
		// Assert verificação
		Assertions.assertEquals(expectedValue, acc.getBalance());
		
	
	
	}
	
	

}
