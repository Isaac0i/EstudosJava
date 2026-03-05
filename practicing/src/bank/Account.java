package bank;

public class Account {
    private static int counter = 0;
    private Integer accountNumber;
    private Double balance;
    private String holder;


    public Account(Double balance, String holder) {
        if(!(balance == 0)){ this.balance = balance;} else {this.balance = 0.0;}
        this.holder = holder;
        this.accountNumber = ++counter;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void getBalance() {
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
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    @Override
    public String toString() {
        return "Name: " + holder + ", Balance: " + balance + ", Account Number: " + accountNumber;
    }
}
