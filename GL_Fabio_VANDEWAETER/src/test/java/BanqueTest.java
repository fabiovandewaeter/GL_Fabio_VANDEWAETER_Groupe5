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
}
