import java.util.List;

public abstract class AbstractCompte {
	abstract public double getCredit();
	
	abstract public double getDebit();
	
	abstract public List<Double> getCreditsArray();
	
	abstract public List<Double> getDebitsArray();
	
	abstract public int getCreditIndex();
	
	abstract public int getDebitIndex();
	
	abstract public void creditAccount(double amount);
	
	abstract public void debitAccount(double amount) throws DebitGreaterThanBalanceException;
	
	abstract public double getBalance();
}
