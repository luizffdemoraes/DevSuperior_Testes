package tests.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;

class AccountTest {
	
	/*
	 * Fun��o Deposito deve incrementar e descontar a taxa quando a quantia for positiva
	 */

	@Test
	public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
		// Arrange cenario
		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = new Account(1L, 0.0);

		// Act acao
		acc.deposit(amount);

		// Assert verificacao se os valores s�o iguais
		Assertions.assertEquals(expectedValue, acc.getBalance());

	}
	/*
	 * Fun��o deposito n�o faz nada quando informar uma quantia negatia
	 */
	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {
		// Arrange cen�rio
		double expectedValue = 100.0;
		Account acc = new Account(1L, 0.0);
		double amount = -200;
		
		// Act a��o
		acc.deposit(amount);
		
		// Assert verifica��o
		Assertions.assertEquals(expectedValue, acc.getBalance());
		
	
	
	}
	
	

}
