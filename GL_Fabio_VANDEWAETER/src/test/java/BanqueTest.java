import static org.junit.jupiter.api.Assertions.assertEquals;
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
		assertEquals(0, this.b.getAccountBalance(id1));
		assertEquals(0, this.b.getAccountBalance(id2));
		this.b.creditCompte(id1, 1000);
		assertEquals(1000, this.b.getAccountBalance(id1));
		assertEquals(0, this.b.getAccountBalance(id2));
	}
	
	@Test
	public void debitAccountWorks() {
		int id1 = this.b.createCompte();
		int id2 = this.b.createCompteEpargne();
		assertEquals(0, this.b.getAccountBalance(id1));
		assertEquals(0, this.b.getAccountBalance(id2));
		this.b.creditCompte(id1, 1000);
		this.b.debitCompte(id1, 500);
		assertEquals(500, this.b.getAccountBalance(id1));
		assertEquals(0, this.b.getAccountBalance(id2));
	}
	
	@Test
	public void creditAccountThrowsAnAccountDoesNotExistException() {
		assertThrows(AccountDoesNotExistException.class, () -> this.b.creditAccount(0));
	}
	
	@Test
	public void debitAccountThrowsAnAccountDoesNotExistException() {
		assertThrows(AccountDoesNotExistException.class, () -> this.b.debitAccount(0));
	}
	
	@Test
	public void getAccountBalanceThrowsAnAccountDoesNotExistException() {
		assertThrows(AccountDoesNotExistException.class, () -> this.b.getAccountBalance(0));
	}
}
