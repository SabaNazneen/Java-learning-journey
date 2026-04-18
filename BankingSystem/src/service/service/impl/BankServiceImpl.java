package service.service.impl;

import domain.Account;
import domain.Customer;
import domain.Transaction;
import domain.Type;
import exceptions.AccountNotFoundException;
import exceptions.InsufficientFundsException;
import exceptions.ValidationException;
import repository.AccountRepositary;
import repository.CustomerRepository;
import repository.TransactionRepository;
import service.BankService;
import util.Validation;

import javax.management.openmbean.InvalidOpenTypeException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class BankServiceImpl implements BankService {
    private final AccountRepositary accountRepositary = new AccountRepositary();
    private final TransactionRepository transactionRepository = new TransactionRepository();
    private final CustomerRepository customerRepository = new CustomerRepository();
    private final Validation<String> validateName = name ->{
        if(name==null || name.isBlank()) throw new ValidationException("Name cannot be null");
    };
    private final Validation<String> validateEmail = email->{
        if(email==null || email.isBlank()) throw new ValidationException("Email cannot be null");
    };
    private final Validation<String> validateType = type->{
        if(type==null || !(type.equalsIgnoreCase("SAVINGS")||type.contains("CURRENT"))) throw new ValidationException("Type must be SAVINGS or CURRENT");
    };
    private final Validation<Double> validateAmountPositive = amount->{
        if(amount==null || amount<0) throw new ValidationException("Please enter valid amount");
    };

    @Override
    public String openAccount(String name, String email, String accountType) throws ValidationException {
        validateName.validate(name);
        validateEmail.validate(email);
        validateType.validate(accountType);
        String customerId = UUID.randomUUID().toString();
        //Create Customer

        Customer c = new Customer(customerId, name, email);
        customerRepository.save(c);
        String accountNumber = getAccountNumber();
        Account account = new Account(accountNumber, customerId, (double) 0, accountType);
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
    public void deposit(String accountNumber, Double amount, String deposit) throws ValidationException {
        validateAmountPositive.validate(amount);
        Account account = accountRepositary.findByNumber(accountNumber)
                .orElseThrow(()->new AccountNotFoundException("Account not found: "+accountNumber));
                account.setBalance(account.getBalance()+amount);
        String note = "Deposited";
        Transaction transaction = new Transaction(UUID.randomUUID().toString(),Type.DEPOSIT,account.getAccountNumber(),amount,LocalDateTime.now(),note);
                transactionRepository.add(transaction);
    }

    @Override
    public void withdraw(String accountNumber, Double amount, String note) throws ValidationException {
        validateAmountPositive.validate(amount);
        Account account = accountRepositary.findByNumber(accountNumber)
                .orElseThrow(()->new AccountNotFoundException("Account not found: "+accountNumber));
        if(account.getBalance()-amount<0){
            throw new InsufficientFundsException("Insufficient balance");
        }
        account.setBalance(account.getBalance()-amount);
        Transaction transaction = new Transaction(UUID.randomUUID().toString(),Type.WITHDRAW,account.getAccountNumber(),amount,LocalDateTime.now(),note);
        transactionRepository.add(transaction);

    }

    @Override
    public void transfer(String fromAcc, String toAcc, Double amount, String transfer) throws ValidationException {
        validateAmountPositive.validate(amount);
        if(fromAcc.equals(toAcc)){
            throw new ValidationException("Transfer from and to cannot be the same");
        }
        Account from = accountRepositary.findByNumber(fromAcc)
                .orElseThrow(()->new AccountNotFoundException("Account not found: "+fromAcc));
        Account to = accountRepositary.findByNumber(toAcc)
                .orElseThrow(()->new AccountNotFoundException("Account not found: "+toAcc));
        if(from.getBalance()-amount<0){
            throw new InsufficientFundsException("Insufficient balance");
        }
        from.setBalance(from.getBalance()-amount);
        Transaction fromTransaction = new Transaction(UUID.randomUUID().toString(),Type.TRANSFER_OUT,from.getAccountNumber(),amount,LocalDateTime.now(),"Transfer");
        transactionRepository.add(fromTransaction);
        to.setBalance(to.getBalance()-amount);
        Transaction toTransaction = new Transaction(UUID.randomUUID().toString(),Type.TRANSFER_IN,to.getAccountNumber(),amount,LocalDateTime.now(),"Transfer");
        transactionRepository.add(toTransaction);
    }

    @Override
    public List<Transaction> getStatement(String account) {
        return transactionRepository.findByAccount(account).stream()
                .sorted(Comparator.comparing(Transaction::getTimestamp))
                .collect(Collectors.toList());
    }

    @Override
    public List<Account> searchAcccountsByCustomerName(String q) {
        String query = (q==null) ? "":q.toLowerCase();
        /* List<Account> result = new ArrayList<>();
        for(Customer c: customerRepository.findAll())
        {
            if(c.getName().toLowerCase().contains(query))
                result.addAll(accountRepositary.findByCustomerId(c.getId()));
        }
        result.sort(Comparator.comparing(Account::getAccountNumber));
        return result;*/
        return customerRepository.findAll().stream()
                .filter(c->c.getName().toLowerCase().contains(query))
                .flatMap(c->accountRepositary.findByCustomerId(c.getId()).stream())
                .collect(Collectors.toList());
    }

    private String getAccountNumber() {
        int size = accountRepositary.findAll().size()+1;
        return String.format("AC%06d",size);
    }
}
