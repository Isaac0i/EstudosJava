package bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Integer, Account> accounts = new HashMap<>();
        int option;

        System.out.println("Welcome to Bank Account!");
        do {
            System.out.println("Chose your option: \n1.Create a Account\n2.Check Balance\n3.Deposit / Withdraw\n4.Transfer Money\n5.List Clients\n6.Exit");
            option = parseInt(sc.nextLine());

            switch(option) {
                case 1:
                    System.out.println("Enter Holder Name: ");
                    String holderName = sc.nextLine();
                    System.out.println("Enter Account Balance: ");
                    Double balance = parseDouble(sc.nextLine());

                    Account account = new Account(balance, holderName);
                    accounts.put(account.getAccountNumber(),  account);
                    System.out.println("Account Created!");
                    break;
                case 2:
                    System.out.println("Plase, Inform the account number: ");
                    Integer acNumber = parseInt(sc.nextLine());
                    if (accounts.containsKey(acNumber)) {
                        Account ac = accounts.get(acNumber);
                        ac.showBalance();
                    } else {
                        System.out.println("Accont does not exist!");
                    }
                    break;
                case 3:
                    System.out.println("Enter Account Number: ");
                    Integer acNum = parseInt(sc.nextLine());
                    if (accounts.containsKey(acNum)) {
                        Account ac = accounts.get(acNum);
                        System.out.println("You want: \n1.deposit \n2.withdraw");
                        int option2 = parseInt(sc.nextLine());
                        if (option2 == 1) {
                            System.out.println("Enter the deposit amount: ");
                            ac.deposit(parseDouble(sc.nextLine()));
                            System.out.println("Deposited Successfully!");
                            break;
                        } else {
                            System.out.println("Enter the withdrawal amount: ");
                            ac.withdraw(parseDouble(sc.nextLine()));
                            System.out.println("Withdrawn Successfully!");
                        }
                        break;
                    }
                case 4:
                    System.out.println("Enter Account Number: ");
                    Integer accountNum = parseInt(sc.nextLine());
                    if (accounts.containsKey(accountNum)) {
                        Account ac = accounts.get(accountNum);
                        System.out.println("How much do you want to transfer?: ");
                        double amount = parseDouble(sc.nextLine());
                        System.out.println("Inform the account number do you want to transfer: ");
                        Integer ac2Num =  parseInt(sc.nextLine());
                        if (accounts.containsKey(ac2Num)) {
                            Account ac2 = accounts.get(ac2Num);
                            ac.transferFunds(amount, ac2);
                        } else {
                            System.out.println("Destiny account does not exist!");
                        }
                    }
                    break;
                case 5:
                    System.out.println("List Clients:");
                    Double soma = 0d;
                    for (Map.Entry<Integer, Account> entry : accounts.entrySet()) {
                        System.out.println(entry.getValue().getHolder());
                        soma += entry.getValue().getBalance();
                    }
                    System.out.println("Full amount: " + soma);
                    break;
                case 6:
                    System.out.println("Turning off...");
                    break;
                default:
                    System.out.println("Invalid option!");
                    break;
            }
        } while (option != 6);

    }
}
