
public class Compte {
	private int credit;
	private int debit;
	
	public Compte() {
		this.credit = 0;
		this.debit = 0;
	}
	
	public int getCredit() {
		return this.credit;
	}
	
	public int getDebit() {
		return this.debit;
	}
	
	public void creditAccount(int amount) {
		if (amount >= 0) {
			this.credit += amount;
		}
	}
	
	public void debitAccount(int amount) {
		if (amount >= 0) {
			this.debit += amount;
		}
	}
	
	public int getBalance() {
		return this.credit-this.debit;
	}
}