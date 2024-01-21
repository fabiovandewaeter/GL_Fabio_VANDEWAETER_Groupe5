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

	public int numberOfComptes() {
		return this.comptes.size();
	}

	public int createCompte() {
		this.comptes.add(new Compte());
		return this.comptes.size()-1;
	}
	
	public int createCompteEpargne() {
		this.comptes.add(new CompteEpargne(2.0));
		return this.comptes.size()-1;
	}
}