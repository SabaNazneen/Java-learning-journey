package service;

import domain.Account;
import domain.Transaction;
import exceptions.ValidationException;

import java.util.List;
import java.util.Map;

public interface BankService {
    String openAccount(String name, String email,String accountType) throws ValidationException;
    List<Account>listAccounts();

    void deposit(String accountNumber, Double amount, String deposit) throws ValidationException;
    void withdraw(String accountNumber,Double amount, String withdraw) throws ValidationException;

    void transfer(String from, String to, Double amount, String transfer) throws ValidationException;

    List<Transaction> getStatement(String account);

    List<Account> searchAcccountsByCustomerName(String t);
}
