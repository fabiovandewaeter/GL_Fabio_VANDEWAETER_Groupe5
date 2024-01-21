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

	public double getAccountBalance(int id) {
		return this.comptes.get(id).getBalance();
	}

	public void creditCompte(int id, double amount) {
		this.comptes.get(id).creditAccount(amount);
	}
	
	public void debitCompte(int id, double amount) {
		try {
			this.comptes.get(id).debitAccount(amount);
		} catch (DebitGreaterThanBalanceException e) {
			e.printStackTrace();
		}
	}
}