import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CompteEpargneTest extends AbstractCompteTest<CompteEpargne>{
	private final static double INTEREST_RATE = 2;
	
	public CompteEpargne createCompte() {
		return new CompteEpargne(INTEREST_RATE);
	}
	
	@Test
	public void checkCreditAndDebitAndInterestAreAt0() {
		assertEquals(0, this.c.getCredit());
		assertEquals(0, this.c.getDebit());
		assertEquals(0, this.c.getInterest());
	}
	
	/*
	@Test
	public void debitAccountDoesNotIncrementCreditVariableWhenShouldResultInNegativeBalance() {
		assertEquals(0, this.c.getDebit());
		this.c.debitAccount(50);
		assertEquals(0, this.c.getDebit());
	}*/
	
	@Test
	public void debitAccountThrowsAnDebitGreaterThanBalanceExceptionWhenShouldResultInNegativeBalance() {
		this.c.creditAccount(100);
		assertDoesNotThrow(() -> this.c.debitAccount(0));
		assertDoesNotThrow(() -> this.c.debitAccount(90));
		assertDoesNotThrow(() -> this.c.debitAccount(10));
		assertThrows(DebitGreaterThanBalanceException.class, () -> this.c.debitAccount(10));
	}
	
	@Test
	public void interestIsCorrectlyCalculated() {
		assertEquals(INTEREST_RATE, this.c.getInterestRate());
		this.c.creditAccount(1000);
		assertEquals((INTEREST_RATE/100)*this.c.getCredit(), this.c.calculInterest());
	}
	
	@Test
	public void echeanceAddInterest() {
		this.c.creditAccount(100);
		assertEquals(0, this.c.getInterest());
		double tempoBalance = this.c.getBalance();
		this.c.echeance();
		assertEquals(tempoBalance+this.c.calculInterest(), this.c.getBalance());
	}
}
