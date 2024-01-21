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
	
	private Compte getAccount(int id) throws AccountDoesNotExistException {
		if (id < this.comptes.size()) {
			return this.comptes.get(id);
		}
		else {
			throw new AccountDoesNotExistException("This account doesn't exist");
		}
	}
	
	public int createCompte() {
		this.comptes.add(new Compte());
		return this.comptes.size()-1;
	}
	
	public int createCompteEpargne() {
		this.comptes.add(new CompteEpargne(2.0));
		return this.comptes.size()-1;
	}

	public double getAccountBalance(int id) throws AccountDoesNotExistException {
		return this.getAccount(id).getBalance();
	}

	public void creditAccount(int id, double amount) throws AccountDoesNotExistException {
		this.getAccount(id).creditAccount(amount);
	}
	
	public void debitAccount(int id, double amount) throws AccountDoesNotExistException {
		try {
			this.getAccount(id).debitAccount(amount);
		} catch (DebitGreaterThanBalanceException e) {
			e.printStackTrace();
		}
	}
}