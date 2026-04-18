package app;

import exceptions.ValidationException;
import service.BankService;
import service.service.impl.BankServiceImpl;

import java.util.Scanner;

public class Main {
    static void main() throws ValidationException {
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankServiceImpl();
        boolean running = true;
        while(running) {
            System.out.println("Welcome to Console Bank");
            System.out.println("""
                    1)Open Account
                    2)Deposit
                    3)Withdraw
                    4)Transfer
                    5)Account Statement
                    6)List Accounts
                    7)Search Accounts by Customer Name
                    0)Exit
                    """);
            System.out.println("CHOOSE: ");
            String choice = scanner.nextLine().trim();
            System.out.println("CHOICE: " + choice);
            switch(choice)
            {
                case "1" -> openAccount(scanner,bankService);
                case "2" -> deposit(scanner,bankService);
                case "3" -> withdraw(scanner,bankService);
                case "4" -> transfer(scanner, bankService);
                case "5" -> accountStatement(scanner,bankService);
                case "6" -> listAccountts(scanner, bankService);
                case "7" -> searchAccounts(scanner,bankService);
                case "0" -> running = false;
            }
        }
    }

    private static void openAccount(Scanner scanner,BankService bankService) throws ValidationException {
        System.out.println("CUSTOMER NAME: ");
        String name = scanner.nextLine().trim();
        System.out.println("CUSTOMER EMAIL: ");
        String email = scanner.nextLine().trim();
        System.out.println("Account Type(SAVINGS/CURRENT): ");
        String type = scanner.nextLine().trim();
        System.out.println("Initial deposit (optional, blank for 0): ");
        String amountStr = scanner.nextLine().trim();
        if(amountStr.isBlank()) amountStr = "0";
        Double initialDeposit = Double.parseDouble(amountStr);
        String accountNumber = bankService.openAccount(name,email,type);
        if(initialDeposit > 0)
            bankService.deposit(accountNumber,initialDeposit,"Inital Deposit");
        System.out.println("Account opened with account number: " + accountNumber);
    }

    private static void deposit(Scanner scanner,BankService bankService) throws ValidationException {

        System.out.println("Account number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.println("Amount: ");
        Double amount = Double.valueOf(scanner.nextLine().trim());

        bankService.deposit(accountNumber,amount,"Deposit");
        System.out.println("Amount deposited successfully");


    }

    private static void withdraw(Scanner scanner, BankService bankService) {
        System.out.println("Account number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.println("Amount: ");
        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankService.withdraw(accountNumber,amount,"Withdraw");
        System.out.println("Amount withdrawn successfully");
    }

    private static void transfer(Scanner scanner,BankService bankService) throws ValidationException {
        System.out.println("From Account: ");
        String from = scanner.nextLine().trim();
        System.out.println("To Account: ");
        String to = scanner.nextLine().trim();
        System.out.println("Amount: ");
        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankService.transfer(from,to,amount,"Transfer");
    }

    private static void accountStatement(Scanner scanner,BankService bankService) {
        System.out.println("Account number: ");
        String account = scanner.nextLine().trim();
        bankService.getStatement(account).forEach(t->
                System.out.println(t.getTimestamp()+ " | "+t.getType()+ " | "+t.getAmount()+" | "+t.getNote()));

    }

    private static void listAccountts(Scanner scanner, BankService bankService) {
        bankService.listAccounts().forEach(a->
        { System.out.println(a.getAccountNumber() +" | "+ a.getAccountType()+" | " +a.getBalance());
    });

    }

    private static void searchAccounts(Scanner scanner,BankService bankService) {
        System.out.println("Customer name contains: ");
        String t = scanner.nextLine().trim();
        bankService.searchAcccountsByCustomerName(t).forEach(account->
                System.out.println(account.getAccountNumber() +" | "+account.getAccountType()+" | "+account.getBalance()));
    }


}
