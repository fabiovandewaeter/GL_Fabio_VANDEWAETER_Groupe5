import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CompteTest {
	
	@Test
	public void newAccountsStartWithCreditAndDebitOf0() {
		Compte c = new Compte();
		assertEquals(0, c.getCredit());
		assertEquals(0, c.getDebit());
	}
	
	@Test
	public void creditAccountIncrementsCreditVariable() {
		Compte c = new Compte();
		assertEquals(0, c.getCredit());
		c.creditAccount(50);
		assertEquals(50, c.getCredit());
	}

}
