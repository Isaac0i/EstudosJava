package bank;

public class CheckingAccount extends Account {

    private double limit = 2.000;
    private final double fee = 2.0;

    public CheckingAccount(Double balance, String holder) {
        super(balance, holder);
    }

    @Override
    public boolean withdraw(double amount) {
        double totalWithdraw = amount + fee;

        if (this.balance >= totalWithdraw) {
            this.balance -= totalWithdraw;
            return true;
        } else if (this.balance + this.limit >= totalWithdraw) {
            double neededFromLimit = totalWithdraw - this.balance;

            this.balance = 0.0;
            this.limit -= neededFromLimit;

            System.out.println("Using the special limit...");
            return true;
        }else {
            System.out.println("Insufficient funds (Limit exceeded)!");
            return false;
        }
    }
}
