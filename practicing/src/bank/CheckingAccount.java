package bank;

public class CheckingAccount extends Account {

    Double limit = 2.000;

    public CheckingAccount(Double balance, String holder) {
        super(balance, holder);
    }

    @Override
    public boolean withdraw(double amount) {
        if(this.balance >= amount){
            this.balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds!");
            return false;
        }
    }
}
