
public class CompteEpargne extends Compte{
	private double interestRate;
	
	public CompteEpargne(double interestRate) {
		super();
		this.interestRate = interestRate;
	}
	
	public void debitAccount(double amount) {
		if ((this.getDebit() + amount) <= this.getCredit()) {
			super.debitAccount(amount);
		}
	}
}
