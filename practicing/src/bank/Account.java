package bank;

public class Account {
    protected static int counter = 0;
    protected Integer accountNumber;
    protected Double balance;
    private String holder;

    public String getHolder() {
        return holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Account(Double balance, String holder) {
        this.balance = (balance != null) ? balance : 0.0;
        this.holder = holder;
        this.accountNumber = ++counter;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void showBalance() {
        System.out.println("Holder: " + this.holder + " \nBalance: " + this.balance);
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public boolean withdraw(double amount) {
        if(this.balance >= amount){
            this.balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient funds!");
            return false;
        }
    }

    public void transferFunds(double amount, Account account) {
        if(this.withdraw(amount)){
            account.deposit(amount);
            System.out.println("Transfer successful!");
        }
    }

    @Override
    public String toString() {
        return "Name: " + holder + ", Balance: " + balance + ", Account Number: " + accountNumber;
    }
}
