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

	public Compte createCompte() {
		Compte newAccount = new Compte();
		this.comptes.add(newAccount);
		return newAccount;
	}
	
	public CompteEpargne createCompteEpargne() {
		CompteEpargne newAccount = new CompteEpargne(2.0);
		this.comptes.add(newAccount);
		return newAccount;
	}
}