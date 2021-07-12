package tests.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

class AccountTest {

	/*
	 * Função Deposito deve incrementar e descontar a taxa quando a quantia for
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

	/*
	 * Função Full With Draw deveria limpar o saldo e retornar o saldo total
	 */
	@Test
	public void fullWithdrawShouldClearBalance() {
		// Arrange cenário
		double expectedValue = 0.0;
		double initialBalance = 800;
		Account acc = AccountFactory.createAccount(initialBalance);

		// Act ação
		double result = acc.fullWithdraw();

		// Assertion Verificação
		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);
	}

	/*
	 * Função With Draw deveria decrementar o saldo quando o saldo estiver
	 * disponivel
	 */
	@Test
	public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {
		// Arrange cenário
		Account acc = AccountFactory.createAccount(800.0);

		// Act ação
		acc.withdraw(500.0);

		// Assertion Verificação
		Assertions.assertEquals(300, acc.getBalance());
	}

	/*
	 * Função With Draw quando o saldo for insuficiente deveria lançar exception
	 */
	@Test
	public void withdrawShouldThrowExceptionWhenInsufficientBalance() {

		// Assertion Verificação
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Arrange cenário
			Account acc = AccountFactory.createAccount(800.0);

			// Act ação
			acc.withdraw(801.0);

		});
	}

}
