import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BanqueTest {
	private Banque b;
	
	@BeforeEach
	void init() {
		this.b = new Banque();
	}
	
	@Test
	public void newBanqueHasNoCompte() {
		assertTrue(this.b.getComptes().isEmpty());
	}
	
	@Test
	public void createCompteWorks() {
		assertEquals(0, this.b.numberOfComptes());
		this.b.createCompte();
		assertEquals(1, this.b.numberOfComptes());
	}
	
	@Test
	public void createCompteEpargneWorks() {
		assertEquals(0, this.b.numberOfComptes());
		this.b.createCompteEpargne();
		assertEquals(1, this.b.numberOfComptes());
	}
	
	@Test
	public void currentIdIncresesWithCompteCreation() {
		int id = this.b.createCompte();
		assertEquals(0, id);
		id = this.b.createCompte();
		assertEquals(1, id);
	}
	
	@Test
	public void creditAccountWorks() {
		int id1 = this.b.createCompte();
		int id2 = this.b.createCompteEpargne();
		try {
			assertDoesNotThrow(() -> this.b.getAccountBalance(id1));
			assertDoesNotThrow(() -> this.b.getAccountBalance(id2));
			assertEquals(0, this.b.getAccountBalance(id1));
			assertEquals(0, this.b.getAccountBalance(id2));
			assertDoesNotThrow(() -> this.b.creditAccount(id1, 1000));
			assertDoesNotThrow(() -> this.b.getAccountBalance(id1));
			assertDoesNotThrow(() -> this.b.getAccountBalance(id2));
			assertEquals(1000, this.b.getAccountBalance(id1));
			assertEquals(0, this.b.getAccountBalance(id2));
		} catch (AccountDoesNotExistException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void debitAccountWorks() {
		int id1 = this.b.createCompte();
		int id2 = this.b.createCompteEpargne();
		try {
			assertDoesNotThrow(() -> this.b.getAccountBalance(id1));
			assertDoesNotThrow(() -> this.b.getAccountBalance(id2));
			assertEquals(0, this.b.getAccountBalance(id1));
			assertEquals(0, this.b.getAccountBalance(id2));
			assertDoesNotThrow(() -> this.b.creditAccount(id1, 1000));
			assertDoesNotThrow(() -> this.b.debitAccount(id1, 500));
			assertDoesNotThrow(() -> this.b.getAccountBalance(id1));
			assertDoesNotThrow(() -> this.b.getAccountBalance(id2));
			assertEquals(500, this.b.getAccountBalance(id1));
			assertEquals(0, this.b.getAccountBalance(id2));
		} catch (AccountDoesNotExistException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void creditAccountThrowsAnAccountDoesNotExistException() {
		assertThrows(AccountDoesNotExistException.class, () -> this.b.creditAccount(0, 1000));
	}
	
	@Test
	public void debitAccountThrowsAnAccountDoesNotExistException() {
		assertThrows(AccountDoesNotExistException.class, () -> this.b.debitAccount(0, 1000));
	}
	
	@Test
	public void getAccountBalanceThrowsAnAccountDoesNotExistException() {
		assertThrows(AccountDoesNotExistException.class, () -> this.b.getAccountBalance(0));
	}
}
