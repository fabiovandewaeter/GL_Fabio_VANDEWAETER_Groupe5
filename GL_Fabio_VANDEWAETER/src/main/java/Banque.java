import java.util.ArrayList;
import java.util.List;

public class Banque {
	private List<Compte> comptes;
	
	public Banque() {
		this.comptes = new ArrayList<>();
	}

	public List<Compte> getComptes() {
		return this.comptes;
	}
}