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
	
	@Test
	public void creditAccountAppendCreditsArray() {
		assertEquals(0, this.c.getCreditIndex());
		this.c.creditAccount(50);
		assertEquals(1, this.c.getCreditIndex());
		assertEquals(50, this.c.getCredit());
	}
	
	@Test
	public void debitAccountAppendDebitsArray() {
		assertEquals(0, this.c.getDebitIndex());
		this.c.debitAccount(50);
		assertEquals(1, this.c.getDebitIndex());
		assertEquals(50, this.c.getDebit());
	}
	
	@Test
	public void creditAccountResetCreditsArrayWhenMaxCapacityReached() {
		assertEquals(0, this.c.getCreditIndex());
		for(int i=0; i<Compte.ARRAY_SIZE; i++) {
			this.c.creditAccount(50);
		}
		assertEquals(Compte.ARRAY_SIZE, this.c.getCreditIndex());
		double beforeReset = this.c.getCredit();
		this.c.creditAccount(50);
		assertEquals(0, this.c.getCreditIndex());
		assertEquals(beforeReset, this.c.getCredit());
	}
	
	@Test
	public void debitAccountResetDebitsArrayWhenMaxCapacityReached() {
		assertEquals(0, this.c.getDebitIndex());
		for(int i=0; i<Compte.ARRAY_SIZE; i++) {
			this.c.debitAccount(50);
		}
		assertEquals(Compte.ARRAY_SIZE, this.c.getDebitIndex());
		double beforeReset = this.c.getDebit();
		this.c.debitAccount(50);
		assertEquals(0, this.c.getDebitIndex());
		assertEquals(beforeReset, this.c.getDebit());
	}
	
	@Test
	public void creditAccountDoesNotAppendCreditsArrayWhenAdd0() {
		assertEquals(0, this.c.getCreditIndex());
		this.c.creditAccount(0);
		assertEquals(0, this.c.getCreditIndex());
		assertEquals(0, this.c.getCredit());
	}
	
	@Test
	public void debitAccountDoesNotAppendDebitsArrayWhenAdd0() {
		assertEquals(0, this.c.getDebitIndex());
		this.c.debitAccount(0);
		assertEquals(0, this.c.getDebitIndex());
		assertEquals(0, this.c.getDebit());
	}
	
	@Test
	public void creditAccountDoesNotAppendCreditsArrayWhenMoreThan100000() {
		assertEquals(0, this.c.getCreditIndex());
		this.c.creditAccount(100000);
		this.c.creditAccount(100000);
		assertEquals(2, this.c.getCreditIndex());
		assertEquals(200000, this.c.getCredit());
		this.c.creditAccount(100001);
		assertEquals(2, this.c.getCreditIndex());
		assertEquals(200000, this.c.getCredit());
	}
	
	@Test
	public void debitAccountDoesNotAppendDebitsArrayWhenMoreThan100000() {
		assertEquals(0, this.c.getDebitIndex());
		this.c.debitAccount(100000);
		this.c.debitAccount(100000);
		assertEquals(2, this.c.getDebitIndex());
		assertEquals(200000, this.c.getDebit());
		this.c.debitAccount(100001);
		assertEquals(2, this.c.getDebitIndex());
		assertEquals(200000, this.c.getDebit());
	}
}
