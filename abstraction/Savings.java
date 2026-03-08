package three.classdemo.abstraction;

public class Savings extends BankAccount {

    @Override
    public void deposit(double amount) {
        System.out.println("Deposited "+amount+ " into Current Account");
    }

    @Override
    public void withdraw(double amount) {
        System.out.println("Withdrawn");
    }
}
