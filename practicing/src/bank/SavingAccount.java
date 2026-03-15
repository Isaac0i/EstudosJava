package bank;

public class SavingAccount extends Account {

    Double interestRate = 0.5;

    public SavingAccount(Double balance, String holder) {
        super(balance, holder);
    }
}
