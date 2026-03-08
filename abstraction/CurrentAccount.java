package three.classdemo.abstraction;

public class CurrentAccount extends BankAccount{
    private double balance;
    public void setBalance(double balance){
        this.balance = balance;
    }
    public double getBalance(){
        return this.balance;
    }
    public CurrentAccount(double balance){
        this.balance = balance;
    }
    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount +
                " | Balance: " + balance);
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrawn " + amount +
                " | Balance: " + balance);
    }
}
