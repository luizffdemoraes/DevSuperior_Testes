package tests.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

class AccountTest {

	/*
	 * Fun��o Deposito deve incrementar e descontar a taxa quando a quantia for
	 * positiva
	 */

	@Test
	public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {
		// Arrange cenario
		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();

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
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200;

		// Act a��o
		acc.deposit(amount);

		// Assert verifica��o
		Assertions.assertEquals(expectedValue, acc.getBalance());

	}

	/*
	 * Fun��o Full With Draw deveria limpar o saldo e retornar o saldo total
	 */
	@Test
	public void fullWithdrawShouldClearBalance() {
		// Arrange cen�rio
		double expectedValue = 0.0;
		double initialBalance = 800;
		Account acc = AccountFactory.createAccount(initialBalance);

		// Act a��o
		double result = acc.fullWithdraw();

		// Assertion Verifica��o
		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);
	}

	/*
	 * Fun��o With Draw deveria decrementar o saldo quando o saldo estiver
	 * disponivel
	 */
	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		// Arrange cen�rio
		Account acc = AccountFactory.createAccount(800.0);

		// Act a��o
		acc.withdraw(500.0);

		// Assertion Verifica��o
		Assertions.assertEquals(300, acc.getBalance());
	}

	/*
	 * Fun��o With Draw quando o saldo for insuficiente deveria lan�ar exception
	 */
	@Test
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {

		// Assertion Verifica��o
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Arrange cen�rio
			Account acc = AccountFactory.createAccount(800.0);

			// Act a��o
			acc.withdraw(801.0);

		});
	}

}
