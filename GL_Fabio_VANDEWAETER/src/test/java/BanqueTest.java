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
}
