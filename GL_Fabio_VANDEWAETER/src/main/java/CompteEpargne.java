
public class CompteEpargne extends Compte{
	private double interestRate;
	
	public CompteEpargne(double interestRate) {
		super();
		this.interestRate = interestRate;
	}
	
	public void debitAccount(double amount) throws DebitGreaterThanBalanceException {
		if ((this.getDebit() + amount) <= this.getCredit()) {
			super.debitAccount(amount);
		}
		else {
			throw new DebitGreaterThanBalanceException("Not enough credit to do this debit");
		}
	}
}
