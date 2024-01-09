
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
		this.credit += amount;
	}
	
	public void debitAccount(int amount) {
		this.debit += amount;
	}
}