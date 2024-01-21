import java.util.List;
import java.util.ArrayList;

public class Compte {
	public final static int ARRAY_SIZE = 5;
	private final static int MAX_AMOUNT = 100000;
	private List<Double> credits;
	private List<Double> debits;
	private int creditIndex;
	private int debitIndex;
	
	public Compte() {
		this.credits = new ArrayList<>();
		this.debits = new ArrayList<>();
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
	
	public List<Double> getCreditsArray() {
		return this.credits;
	}
	
	public List<Double> getDebitsArray() {
		return this.debits;
	}
	
	public int getCreditIndex() {
		return this.creditIndex;
	}
	
	public int getDebitIndex() {
		return this.debitIndex;
	}
	
	public void creditAccount(double amount) {
		if (amount > 0 && amount <= MAX_AMOUNT) {
			if (this.creditIndex < ARRAY_SIZE) {
				this.credits.add(amount);
				this.creditIndex++;
			}
			else {
				double sum = this.getCredit();
				this.credits.clear();
				this.credits.add(sum);
				this.creditIndex = 0;
				this.creditAccount(amount);
			}
		}
	}
	
	public void debitAccount(double amount) throws DebitGreaterThanBalanceException {
		if (amount > 0 && amount <= MAX_AMOUNT) {
			if (this.debitIndex < ARRAY_SIZE) {
				this.debits.add(amount);
				this.debitIndex++;
			}
			else {
				double sum = this.getDebit();
				this.debits.clear();
				this.debits.add(sum);
				this.debitIndex = 0;
				this.debitAccount(amount);
			}
		}
	}
	
	public double getBalance() {
		return this.getCredit()-this.getDebit();
	}
}