import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CompteEpargneTest extends CompteTest{
	private final static double INTEREST_RATE = 2;
	
	public Compte createCompte() {
		return new CompteEpargne(2.0);
	}
	
	@Test
	public void checkCreditAndDebitAreAt0() {
		assertEquals(0, this.c.getCredit());
		assertEquals(0, this.c.getDebit());
	}
	
	@Test
	public void debitAccountDoesNotIncrementCreditVariableWhenResultInNegativeBalance() {
		assertEquals(0, this.c.getDebit());
		this.c.debitAccount(50);
		assertEquals(0, this.c.getDebit());
	}
}
