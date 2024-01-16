
public class Compte {
	private final static int ARRAY_SIZE = 5;
	private double[] credits;
	private double[] debits;
	private int creditIndex;
	private int debitIndex;
	
	public Compte() {
		this.credits = new double[ARRAY_SIZE];
		this.debits = new double[ARRAY_SIZE];
		this.creditIndex = 0;
		this.debitIndex = 0;
	}
	
	public double getCredit() {
		int res = 0;
		for (double n : this.credits) {
			res += n;
		}
		return res;
	}
	
	public double getDebit() {
		int res = 0;
		for (double n : this.debits) {
			res += n;
		}
		return res;
	}
	
	public double[] getCreditsArray() {
		return this.credits;
	}
	
	public double[] getDebitsArray() {
		return this.debits;
	}
	
	public int getCreditIndex() {
		return this.creditIndex;
	}
	
	public int getDebitIndex() {
		return this.debitIndex;
	}
	
	public void creditAccount(double amount) {
		if (amount > 0) {
			if (this.creditIndex < this.credits.length) {
				this.credits[this.creditIndex] = amount;
				this.creditIndex++;
			}
			else {
				double sum = this.getCredit();
				this.credits = new double[ARRAY_SIZE];
				this.credits[0] = sum;
				this.creditIndex = 0;
			}
		}
	}
	
	public void debitAccount(double amount) {
		if (amount > 0) {
			if (this.debitIndex < this.debits.length) {
				this.debits[this.debitIndex] = amount;
				this.debitIndex++;
			}
			else {
				double sum = this.getDebit();
				this.debits = new double[ARRAY_SIZE];
				this.debits[0] = sum;
				this.debitIndex = 0;
			}
		}
	}
	
	public double getBalance() {
		return this.getCredit()-this.getDebit();
	}
}