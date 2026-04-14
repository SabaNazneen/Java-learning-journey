package service.service.impl;

import domain.Account;
import domain.Transaction;
import domain.Type;
import repository.AccountRepositary;
import repository.TransactionRepository;
import service.BankService;

import javax.management.openmbean.InvalidOpenTypeException;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BankServiceImpl implements BankService {
    private final AccountRepositary accountRepositary = new AccountRepositary();
    private final TransactionRepository transactionRepository = new TransactionRepository();
    @Override
    public String openAccount(String name, String email, String accountType) {
       String customerId = UUID.randomUUID().toString();
        String accountNumber = getAccountNumber();
        Account account = new Account(accountNumber,customerId, (double) 0,accountType);
       //SAVE
        accountRepositary.save(account);
        return accountNumber;
    }

    @Override
    public List<Account> listAccounts() {
        return accountRepositary.findAll().stream()
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());
    }

    @Override
    public void deposit(String accountNumber, Double amount, String deposit) {
        Account account = accountRepositary.findByNumber(accountNumber)
                .orElseThrow(()->new RuntimeException("Account not found: "+accountNumber));
                account.setBalance(account.getBalance()+amount);
        String note = "Deposited";
        Transaction transaction = new Transaction(UUID.randomUUID().toString(),Type.DEPOSIT,account.getAccountNumber(),amount,LocalDateTime.now(),note);
                transactionRepository.add(transaction);
    }

    private String getAccountNumber() {
        int size = accountRepositary.findAll().size()+1;
        return String.format("AC%06d",size);
    }
}
