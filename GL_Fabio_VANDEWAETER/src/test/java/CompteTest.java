import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompteTest {
	private Compte c;
	
	@BeforeEach
	void init() {
		this.c = new Compte();
	}
	
	@Test
	public void newAccountsStartWithCreditAndDebitOf0() {
		Compte c2 = new Compte();
		assertEquals(0, c2.getCredit());
		assertEquals(0, c2.getDebit());
	}
	
	@Test
	public void creditAccountIncrementsCreditVariable() {
		assertEquals(0, this.c.getCredit());
		this.c.creditAccount(50);
		assertEquals(50, this.c.getCredit());
	}
	
	@Test
	public void debitAccountIncrementsDebitVariable() {
		assertEquals(0, this.c.getDebit());
		this.c.debitAccount(50);
		assertEquals(50, this.c.getDebit());
	}
	
	@Test
	public void creditAccountDoesNotIncrementCreditVariableWhenNegativeAmount() {
		assertEquals(0, this.c.getCredit());
		this.c.creditAccount(-50);
		assertEquals(0, this.c.getCredit());
	}
	
	@Test
	public void debitAccountDoesNotIncrementCreditVariableWhenNegativeAmount() {
		assertEquals(0, this.c.getDebit());
		this.c.debitAccount(-50);
		assertEquals(0, this.c.getDebit());
	}
	
	@Test
	public void accountBalanceIsGoodAfterCreditsAndDebits() {
		assertEquals(0, this.c.getBalance());
		this.c.debitAccount(50);
		assertEquals(-50, this.c.getBalance());
		this.c.creditAccount(50);
		assertEquals(0, this.c.getBalance());
	}
}
